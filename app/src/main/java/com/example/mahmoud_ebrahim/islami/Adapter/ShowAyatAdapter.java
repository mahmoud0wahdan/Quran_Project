package com.example.mahmoud_ebrahim.islami.Adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.mahmoud_ebrahim.islami.R;

import java.util.ArrayList;
import java.util.List;


public class ShowAyatAdapter extends RecyclerView.Adapter<ShowAyatAdapter.Viewholder> {


    private List<String> ayats;
    private int soura_ayat_number;
    public ShowAyatAdapter(ArrayList<String> ayats) {
        this.ayats=ayats;
    }

    @NonNull
    @Override
    public Viewholder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new Viewholder(LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.ayat_show_follow_soura_read,viewGroup,false));
    }

    @Override
    public void onBindViewHolder(@NonNull Viewholder viewholder, int i) {
        String s=ayats.get(i);
        viewholder.textView.setText(s+"("+i+")");
    }

    @Override
    public int getItemCount() {
        return ayats.size();
    }

    public class Viewholder extends RecyclerView.ViewHolder{
        TextView textView;

        public Viewholder(View itemView){
            super(itemView);
            textView=itemView.findViewById(R.id.ayat_tv);
        }
    }
}
