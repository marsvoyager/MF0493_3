package com.example.sergiomar_mf04933;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    SharedPreferences prefs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        prefs = getSharedPreferences("PreferenciasApp", Context.MODE_PRIVATE);
        SharedPreferences.Editor shpred =  prefs.edit();

        //shpred.putInt();
        //shpred.commit()
        //prefs.getInt()



    }
}
