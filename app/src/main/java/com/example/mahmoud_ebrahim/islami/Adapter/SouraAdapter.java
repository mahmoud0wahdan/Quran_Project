package com.example.mahmoud_ebrahim.islami.Adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.mahmoud_ebrahim.islami.R;
import com.example.mahmoud_ebrahim.islami.SouraNameDataholder;

public class SouraAdapter extends RecyclerView.Adapter<SouraAdapter.Viewholder> {

    public SouraAdapter() {
    }

    OnIClick onIClick;

    public void setOnIClick(OnIClick onIClick) {
        this.onIClick = onIClick;
    }

    @NonNull
    @Override
    public Viewholder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view=LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.soura_shape,viewGroup,false);

        return new Viewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Viewholder viewholder, final int position) {
        String s=SouraNameDataholder.soura_name[position];
        viewholder.soura_name.setText(s);
        if(onIClick!=null){
            viewholder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onIClick.onIclick(position);
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return SouraNameDataholder.soura_name.length;
    }

    public class Viewholder extends RecyclerView.ViewHolder{

        TextView soura_name;

        public Viewholder(@NonNull View itemView) {
            super(itemView);
            soura_name=itemView.findViewById(R.id.radio_channel_name);
        }

    }

    public interface OnIClick{
        void onIclick(int pos);
    }
}
