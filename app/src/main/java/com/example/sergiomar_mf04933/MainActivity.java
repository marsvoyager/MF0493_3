package com.example.sergiomar_mf04933;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.sergiomar_mf04933.adapter.CustomAdapterCeluloides;
import com.example.sergiomar_mf04933.controller.PeliculaController;
import com.example.sergiomar_mf04933.handlers.ListViewHandler_TCeluloides;
import com.example.sergiomar_mf04933.helper.HelperFactory;
import com.example.sergiomar_mf04933.helper.ICallback;
import com.example.sergiomar_mf04933.model.Pelicula;

import java.util.ArrayList;


public class MainActivity
        extends AppCompatActivity
        implements HelperFactory.Params {

    public class Callback
        implements ICallback
    {
        public void response(){}
    }


    public class PeliculasLVClickCb
        extends Callback
        //implements AdapterView.OnItemClickListener
    {
        Intent IntPelicDetalle;

        public void response()
        {
            startActivity(IntPelicDetalle);
        }
        PeliculasLVClickCb(MainActivity MAthis)
        {
            IntPelicDetalle = new Intent(MAthis, PeliculaDetalle.class);
        }

        public Intent getIntPelicDetalle() {
            return IntPelicDetalle;
        }

        public void setIntPelicDetalle(Intent intPelicDetalle) {
            IntPelicDetalle = intPelicDetalle;
        }
    };

    SharedPreferences prefs;
    CustomAdapterCeluloides lv_adpCelulod;


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //return super.onCreateOptionsMenu(menu);

        // Inflate the menu; this adds items to the action bar
        //if it is present.
        getMenuInflater().inflate(R.menu.crud, menu);
        getMenuInflater().inflate(R.menu.inspir, menu);

        return true;
    }


    @Override
    protected void onResume() {

        super.onResume();
        //Log.v("Proves", "onResume");
        //al tornar de la pantalla de login encara no hem creat la bbdd
        if(lv_adpCelulod==null)
            return;

        //MEMO.clear();
        //MEMO.addAll(ncontroller.getNotas());
        //NotalvAdapter.notifyDataSetChanged();
        lv_adpCelulod.getCeluloides().clear();
        lv_adpCelulod.getCeluloides().addAll(
                PeliculaController.get(this)
                        .getPeliculas());

        lv_adpCelulod.notifyDataSetChanged();

    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayList<Pelicula> lceluloides= new ArrayList<Pelicula>();
        PeliculasLVClickCb pclick =new PeliculasLVClickCb(this);
        ListViewHandler_TCeluloides lvh = new ListViewHandler_TCeluloides(
                lceluloides,
                (ListView) findViewById(R.id.lvceluloidesid),
                new ListViewHandler_TCeluloides.callBackItemClick(
                        lceluloides,
                        pclick, pclick.getIntPelicDetalle())
        );

        //
        lv_adpCelulod = new CustomAdapterCeluloides(
                this, R.layout.row_celuloides,
                lvh.getLceluloides()
        );
        //and autoset de Listview! inside
        lvh.setLv_adpCelulod(lv_adpCelulod);
        lv_adpCelulod.getCeluloides().clear();
        lv_adpCelulod.getCeluloides().addAll(
                PeliculaController.get(this)
                        .getPeliculas());

        lv_adpCelulod.notifyDataSetChanged();



        //getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        prefs = getSharedPreferences("PreferenciasApp", Context.MODE_PRIVATE);
        SharedPreferences.Editor shpred =  prefs.edit();

        //UUID codlogin = UUID.randomUUID();
        int UserLogged = prefs.getInt("UsuarioIdentificado", -1);

        if(UserLogged == -1){
            //Preparar el intent del Login
            Intent loginintent = new Intent(MainActivity.this, LoginActivity.class);
            startActivity(loginintent);
        }
        else{
            //Omitir el Login y presentar la pantalla
            //principal

            //lvh.getLv_celuloides().setOnItemClickListener(
              //      new ListViewHandler_TCeluloides.callBackItemClick(pclick, pclick.getIntPelicDetalle()));


            //
            //Testing a filled list
            //Testing a filled list
            //Testing a filled list
            //Testing a filled list
            //Testing a filled list
            //Testing a filled list  DELETE!!!!!!!!!

            /*lvh.getLceluloides().add(
                    new Pelicula(
                            "DATOPRUEBALa vida es bella",
                            "Un clásico de Oscar",
                            "1999",
                            Pelicula.emPuntuacion._0,
                            "https://i.imgur.com/psiUtWd.png"
                    ));*/


        }
    }
    private void openDetail(int position)
    {
       // lvh.getLceluloides().get(position).getId();

        //Intent intent = new Intent(this
          //      , DetailActivity.class);
        //intent.putExtra("destName", dest.getName());
        //intent.putExtra("destDist", dest.getDistance());
        //intent.putExtra("image", dest.getImageUrl());
        //startActivity(intent);
    }

    @Override
    public boolean onSupportNavigateUp() {
        //finish();
        //return true;
        return super.onSupportNavigateUp();
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.nuev_pelicid:
                Intent IntPelicDetalle = new Intent(this,
                        PeliculaDetalle.class);

                IntPelicDetalle.putExtra("modoEdicion", false);
                this.startActivity(IntPelicDetalle);

                break;
            case R.id.inspir_pelicid:
                Intent IntInspiracio = new Intent(this,
                        Inspiracio.class);

                //IntPelicDetalle.putExtra("modoEdicion", true);
                this.startActivity(IntInspiracio);

                break;

         /*   case R.id.item1:

                Toast.makeText(getApplicationContext(), "item1",
                        Toast.LENGTH_LONG).show();

                return (true);

            case R.id.item2:

                Toast.makeText(getApplicationContext(), "item2",
                        Toast.LENGTH_LONG).show();*/
        }
        return super.onOptionsItemSelected(item);
    }
}
