package com.example.sergiomar_mf04933;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

import java.util.UUID;

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
        //UUID codlogin = UUID.randomUUID();
        int UserLogged = prefs.getInt("UsuarioIdentificado", -1);
        if(UserLogged == -1){
            //Preparar el intent del Login
            shpred.putInt("UsuarioIdentificado", 0);
        }
        else{
            //Omitir el Login y presentar la pantalla
            //principal
        }
    }
}
