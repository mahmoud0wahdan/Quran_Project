package com.example.mahmoud_ebrahim.islami;

import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.support.design.widget.BottomNavigationView;

import com.example.mahmoud_ebrahim.Base.BaseDialogActivity;


public class MainActivity extends BaseDialogActivity {

    Fragment fragment;
    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_quran:
                     fragment=new QuranFragment();
                     getSupportFragmentManager().beginTransaction()
                             .replace(R.id.fragment_container,fragment)
                             .commit();
                    return true;
                case R.id.navigation_tasbeh:
                    fragment=new TasbehFragment();
                    getSupportFragmentManager().beginTransaction()
                            .replace(R.id.fragment_container,fragment)
                            .commit();
                    return true;
                case R.id.navigation_radio:
                    fragment=new RadioFragment();
                    getSupportFragmentManager().beginTransaction()
                            .replace(R.id.fragment_container,fragment)
                            .commit();
                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomNavigationView navigation =  findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        navigation.setSelectedItemId(R.id.navigation_quran);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        TasbehFragment.allahAkbarCount_atOnce=0;
        TasbehFragment.sobhanAllahCount_atOnce=0;
        TasbehFragment.laElahElaAllahCount_atOnce=0;
        TasbehFragment.alhamedllahCount_atOnce=0;
    }
}
