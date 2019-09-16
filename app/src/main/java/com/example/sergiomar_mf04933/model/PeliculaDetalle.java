package com.example.sergiomar_mf04933.model;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

import com.example.sergiomar_mf04933.R;

public class PeliculaDetalle extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pelicula_detalle);

        int idxPelicula = getIntent().getIntExtra("peliculaindex",-1);
        String uudiPelicula= getIntent().getStringExtra("peliculauuid");

        //pintent.putExtra("peliculaindex", position);
        //pintent.putExtra("peliculauuid", p.getId());

        if(idxPelicula >-1)
            Toast.makeText(getApplicationContext(), "click click abriendo indice"+ idxPelicula +":"+uudiPelicula, Toast.LENGTH_LONG).show();
    }
}
