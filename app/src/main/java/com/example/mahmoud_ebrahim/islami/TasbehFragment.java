package com.example.mahmoud_ebrahim.islami;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;


public class TasbehFragment extends Fragment {

    ImageView sephaClicked,restartClicked;
    Spinner spinner;
    TextView count_at_once;
    TextView total_count;
    View view;
    public TasbehFragment() {
        // Required empty public constructor
    }

    int selected_position=0;
    protected static int allahAkbarCount_atOnce,allahAkbarCount=0;
    protected static int sobhanAllahCount_atOnce,sobhanAllahCount=0;
    protected static int laElahElaAllahCount_atOnce,laElahElaAllahCount=0;
    protected static int alhamedllahCount_atOnce,alhamedllahCount=0;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view= inflater.inflate(R.layout.fragment_tasbeh, container, false);
        count_at_once=view.findViewById(R.id.count_at_once);
        total_count=view.findViewById(R.id.total_count);
        spinner=view.findViewById(R.id.spinner_zekr);
        sephaClicked=view.findViewById(R.id.sebha_image);
        restartClicked=view.findViewById(R.id.refresh);
        restartClicked.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onRestartCliked();
            }
        });
        sephaClicked.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onSebhaClicked();
            }
        });
        List<String> items=new ArrayList<>();
        items.add("اللة أكبر");
        items.add("الحمد لله");
        items.add("لا اله الا الله");
        items.add("سبحان الله");
        ArrayAdapter<String> adapter=new ArrayAdapter<>(view.getContext(),android.R.layout.simple_spinner_item,items);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                selected_position=position;
                operationOnSpinnerItemSelected(position);

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            spinner.setSelection(0);
            }
        });
        return view;
    }


    public void operationOnSpinnerItemSelected(int position){
        switch (position)
        {
            case 0:
                count_at_once.setText(allahAkbarCount_atOnce+"");
                total_count.setText(allahAkbarCount+"");
                break;
            case 1:
                count_at_once.setText(alhamedllahCount_atOnce+"");
                total_count.setText(alhamedllahCount+"");
                break;
            case 2:
                count_at_once.setText(laElahElaAllahCount_atOnce+"");
                total_count.setText(laElahElaAllahCount+"");
                break;
            case 3:
                count_at_once.setText(sobhanAllahCount_atOnce+"");
                total_count.setText(sobhanAllahCount+"");
                break;
        }
    }

    public void onSebhaClicked(){

        switch (selected_position)
        {
            case 0:
                count_at_once.setText((++allahAkbarCount_atOnce)+"");
                total_count.setText((++allahAkbarCount)+"");
                break;
            case 1:
                count_at_once.setText((++alhamedllahCount_atOnce)+"");
                total_count.setText((++alhamedllahCount)+"");
                break;
            case 2:
                count_at_once.setText((++laElahElaAllahCount_atOnce)+"");
                total_count.setText((++laElahElaAllahCount)+"");
                break;
            case 3:
                count_at_once.setText((++sobhanAllahCount_atOnce)+"");
                total_count.setText((++sobhanAllahCount)+"");
                break;
        }

    }
    public void onRestartCliked(){

        count_at_once.setText("0");
        total_count.setText("0");
        allahAkbarCount_atOnce=0;allahAkbarCount=0;
         sobhanAllahCount_atOnce=0;sobhanAllahCount=0;
         laElahElaAllahCount_atOnce=0;laElahElaAllahCount=0;
         alhamedllahCount_atOnce=0;alhamedllahCount=0;
    }
}
