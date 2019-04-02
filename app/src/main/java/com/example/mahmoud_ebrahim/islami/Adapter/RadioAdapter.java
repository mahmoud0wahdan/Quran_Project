package com.example.mahmoud_ebrahim.islami.Adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.mahmoud_ebrahim.Api.model.RadiosItem;
import com.example.mahmoud_ebrahim.islami.R;

import java.util.List;

public class RadioAdapter extends RecyclerView.Adapter<RadioAdapter.Viewholder> {

    List<RadiosItem> radioChannals;
    OnPlayPauseClicked onPlayPauseClicked;

    public RadioAdapter(List<RadiosItem> radioChannals) {
        this.radioChannals = radioChannals;
    }

    public void setOnPlayPauseClicked(OnPlayPauseClicked onPlayPauseClicked) {
        this.onPlayPauseClicked = onPlayPauseClicked;
    }

    public void changeData(List<RadiosItem> radioChannals){
        this.radioChannals=radioChannals;
        notifyDataSetChanged();
    }
    @NonNull
    @Override
    public Viewholder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view=LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.radio_channals_shape,viewGroup,false);
        return new Viewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Viewholder viewholder, final int i) {
        final RadiosItem radiosItem=radioChannals.get(i);
        viewholder.radio_channel_name.setText(radiosItem.getName());
        if (onPlayPauseClicked!=null){
            viewholder.radio_play.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onPlayPauseClicked.onPlayClicked(radiosItem);
                }
            });
            viewholder.radio_stop.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onPlayPauseClicked.onPauseClicked(radiosItem);
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        if(radioChannals==null)
            return 0;
        else
            return radioChannals.size();
    }


    class Viewholder extends RecyclerView.ViewHolder{

        TextView radio_channel_name;
        ImageView radio_play;
        ImageView radio_stop;
        public Viewholder(@NonNull View itemView) {
            super(itemView);
            radio_channel_name=itemView.findViewById(R.id.radio_channel_name);
            radio_play= itemView.findViewById(R.id.play_radio);
            radio_stop= itemView.findViewById(R.id.stop_radio);
        }
    }

    public interface OnPlayPauseClicked{
         void onPlayClicked(RadiosItem channal);
         void onPauseClicked( RadiosItem channal);

    }
}