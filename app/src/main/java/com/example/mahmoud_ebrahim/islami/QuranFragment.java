package com.example.mahmoud_ebrahim.islami;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.PagerSnapHelper;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SnapHelper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.mahmoud_ebrahim.islami.Adapter.SouraAdapter;


/**
 * A simple {@link Fragment} subclass.
 */
public class QuranFragment extends Fragment {


    public QuranFragment() {
        // Required empty public constructor
    }



    RecyclerView recyclerView;
    SouraAdapter adapter;
    RecyclerView.LayoutManager layoutManager;
    View view;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view=inflater.inflate(R.layout.fragment_quran, container, false);
        recyclerView=view.findViewById(R.id.soura_view);
        adapter=new SouraAdapter();
        adapter.setOnIClick(new SouraAdapter.OnIClick() {
            @Override
            public void onIclick(int pos) {
                Intent i=new Intent(getActivity(),SouraRead.class);
                i.putExtra("position",pos+"");
                startActivity(i);
            }
        });
        recyclerView.setAdapter(adapter);
        SnapHelper snapHelper=new PagerSnapHelper();
        snapHelper.attachToRecyclerView(recyclerView);

        layoutManager=new GridLayoutManager(container.getContext()
                ,3,LinearLayoutManager.HORIZONTAL,true);
        recyclerView.setLayoutManager(layoutManager);
        return view;
    }

}
