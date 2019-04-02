package com.example.mahmoud_ebrahim.islami;

import android.content.res.AssetManager;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import com.example.mahmoud_ebrahim.islami.Adapter.ShowAyatAdapter;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class SouraRead extends AppCompatActivity {

    RecyclerView ayatRecyclerView;
    LinearLayoutManager layoutManager;
    ShowAyatAdapter adapter;
    TextView souraNameShowUp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_soura_read);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ayatRecyclerView=findViewById(R.id.recyclerview_soura_read);
        souraNameShowUp=findViewById(R.id.soura_name_show_up);

        int position=  Integer.parseInt(getIntent().getStringExtra("position"));

        souraNameShowUp.setText(SouraNameDataholder.soura_name[position]);
        adapter=new ShowAyatAdapter(getayat(position));
        layoutManager=new LinearLayoutManager(getBaseContext());

        ayatRecyclerView.setAdapter(adapter);

        ayatRecyclerView.setLayoutManager(layoutManager);
    }
    public ArrayList<String> getayat(int position){

        ArrayList<String> ayats=new ArrayList<>();
        AssetManager am = this.getAssets();

        try {
            InputStream is = am.open((position+1)+".txt");
            BufferedReader reader = new BufferedReader(new InputStreamReader(is));
            String line;

            while ((line = reader.readLine()) != null)
                ayats.add(line);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return ayats;
    }

}
