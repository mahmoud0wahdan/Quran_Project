package com.example.mahmoud_ebrahim.islami;


import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.PagerSnapHelper;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SnapHelper;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.mahmoud_ebrahim.Api.ApiManager;
import com.example.mahmoud_ebrahim.Api.model.RadiosItem;
import com.example.mahmoud_ebrahim.Api.model.RadiosResponse;
import com.example.mahmoud_ebrahim.Base.BaseDialogActivity;
import com.example.mahmoud_ebrahim.Base.BaseDialogFragment;
import com.example.mahmoud_ebrahim.islami.Adapter.RadioAdapter;


import java.io.IOException;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


/**
 * A simple {@link Fragment} subclass.
 */
public class RadioFragment extends BaseDialogFragment {


    View view;
    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;
    RadioAdapter radioAdapter;
    MediaPlayer mediaPlayer;
    public RadioFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view= inflater.inflate(R.layout.fragment_radio, container, false);
        layoutManager=new LinearLayoutManager(view.getContext(),
                LinearLayoutManager.HORIZONTAL,true);
        radioAdapter=new RadioAdapter(null);
        recyclerView=view.findViewById(R.id.radio_recyclerview);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(radioAdapter);
        SnapHelper snapHelper=new PagerSnapHelper();
        snapHelper.attachToRecyclerView(recyclerView);
        getRadioChannals();
        radioAdapter.setOnPlayPauseClicked(new RadioAdapter.OnPlayPauseClicked() {
            @Override
            public void onPlayClicked( RadiosItem channal) {
                playChannel(channal.getRadioUrl());
            }

            @Override
            public void onPauseClicked( RadiosItem channal) {
                stopChannel();
            }
        });
        return view;
    }

    private void getRadioChannals() {
        showProgressBar(R.string.loading);
        ApiManager.getApis()
                .getAllRadioChannals()
                .enqueue(new Callback<RadiosResponse>() {
                    @Override
                    public void onResponse(Call<RadiosResponse> call, Response<RadiosResponse> response) {
                        dismissProgressBar();
                        radioAdapter.changeData(response.body().getRadios());

                    }

                    @Override
                    public void onFailure(Call<RadiosResponse> call, Throwable t) {
                        dismissProgressBar();
                    }
                });
    }

    private void playChannel(String uRL){
        stopChannel();
        mediaPlayer=new MediaPlayer();
        try {
            mediaPlayer.setDataSource(uRL);
            mediaPlayer.prepareAsync();
            mediaPlayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                @Override
                public void onPrepared(MediaPlayer mp) {
                    mp.start();
                }
            });
        }catch (IOException e){
            showMessage(getString(R.string.error),e.getLocalizedMessage()
                    ,getString(R.string.ok));
        }
    }
    private void stopChannel(){
        if (mediaPlayer!=null)
            mediaPlayer.stop();
    }

}
