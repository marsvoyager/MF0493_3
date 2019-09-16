package com.example.sergiomar_mf04933;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.sergiomar_mf04933.adapter.CustomAdapterCeluloides;
import com.example.sergiomar_mf04933.handlers.ListViewHandler_TCeluloides;
import com.example.sergiomar_mf04933.helper.HelperFactory;
import com.example.sergiomar_mf04933.helper.ICallback;
import com.example.sergiomar_mf04933.model.Pelicula;
import com.example.sergiomar_mf04933.model.PeliculaDetalle;

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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

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

            ArrayList<Pelicula> lceluloides= new ArrayList<Pelicula>();
            PeliculasLVClickCb pclick =new PeliculasLVClickCb(this);

            ListViewHandler_TCeluloides lvh = new ListViewHandler_TCeluloides(lceluloides,
                    (ListView) findViewById(R.id.lvceluloidesid),
                    new ListViewHandler_TCeluloides.callBackItemClick(
                            lceluloides, pclick, pclick.getIntPelicDetalle())
            );

            //
            CustomAdapterCeluloides lv_adpCelulod = new CustomAdapterCeluloides(
                    this, R.layout.row_celuloides,
                    lvh.getLceluloides()
            );
            //and autoset de Listview! inside
            lvh.setLv_adpCelulod(lv_adpCelulod);

            lv_adpCelulod.notifyDataSetChanged();

            //lvh.getLv_celuloides().setOnItemClickListener(
              //      new ListViewHandler_TCeluloides.callBackItemClick(pclick, pclick.getIntPelicDetalle()));


            //
            //Testing a filled list
            //Testing a filled list
            //Testing a filled list
            //Testing a filled list
            //Testing a filled list
            //Testing a filled list  DELETE!!!!!!!!!

            lvh.getLceluloides().add(
                    new Pelicula(
                            "DATOPRUEBALa vida es bella",
                            "Un clásico de Oscar",
                            1999,
                            Pelicula.emPuntuacion._0,
                            "https://i.imgur.com/psiUtWd.png"
                    ));
            lvh.getLceluloides().add(
                    new Pelicula(
                            "DATOPRUEBALa vida es bella",
                            "Un clásico de Oscar",
                            1999,
                            Pelicula.emPuntuacion._1,
                            "https://i.imgur.com/psiUtWd.png"
                    ));
            lvh.getLceluloides().add(
                    new Pelicula(
                            "DATOPRUEBALa vida es bella",
                            "Un clásico de Oscar",
                            1999,
                            Pelicula.emPuntuacion._2,
                            "https://i.imgur.com/psiUtWd.png"
                    ));
            lvh.getLceluloides().add(
                    new Pelicula(
                            "DATOPRUEBALa vida es bella",
                            "Un clásico de Oscar",
                            1999,
                            Pelicula.emPuntuacion._3,
                            "https://i.imgur.com/psiUtWd.png"
                    ));
            lvh.getLceluloides().add(
                    new Pelicula(
                            "DATOPRUEBALa vida es bella",
                            "Un clásico de Oscar",
                            1999,
                            Pelicula.emPuntuacion._4,
                            "https://i.imgur.com/psiUtWd.png"
                    ));
            lvh.getLceluloides().add(
                    new Pelicula(
                            "DATOPRUEBALa vida es bella",
                            "Un clásico de Oscar",
                            1999,
                            Pelicula.emPuntuacion._5,
                            "https://i.imgur.com/psiUtWd.png"
                    ));
            lvh.getLceluloides().add(
                    new Pelicula(
                            "DATOPRUEBALa vida es bella",
                            "Un clásico de Oscar",
                            1999,
                            Pelicula.emPuntuacion._5,
                            "https://i.imgur.com/psiUtWd.png"
                    ));
            lvh.getLceluloides().add(
                    new Pelicula(
                            "DATOPRUEBALa vida es bella",
                            "Un clásico de Oscar",
                            1999,
                            Pelicula.emPuntuacion._5,
                            "https://i.imgur.com/psiUtWd.png"
                    ));
            lvh.getLceluloides().add(
                    new Pelicula(
                            "DATOPRUEBALa vida es bella",
                            "Un clásico de Oscar",
                            1999,
                            Pelicula.emPuntuacion._5,
                            "https://i.imgur.com/psiUtWd.png"
                    ));
            lvh.getLceluloides().add(
                    new Pelicula(
                            "DATOPRUEBALa vida es bella",
                            "Un clásico de Oscar",
                            1999,
                            Pelicula.emPuntuacion._5,
                            "https://i.imgur.com/psiUtWd.png"
                    ));
            lvh.getLceluloides().add(
                    new Pelicula(
                            "DATOPRUEBALa vida es bella",
                            "Un clásico de Oscar",
                            1999,
                            Pelicula.emPuntuacion._5,
                            "https://i.imgur.com/psiUtWd.png"
                    ));
            lvh.getLceluloides().add(
                    new Pelicula(
                            "DATOPRUEBALa vida es bella",
                            "Un clásico de Oscar",
                            1999,
                            Pelicula.emPuntuacion._5,
                            "https://i.imgur.com/psiUtWd.png"
                    ));
            lvh.getLceluloides().add(
                    new Pelicula(
                            "DATOPRUEBALa vida es bella",
                            "Un clásico de Oscar",
                            1999,
                            Pelicula.emPuntuacion._5,
                            "https://i.imgur.com/psiUtWd.png"
                    ));
            lvh.getLceluloides().add(
                    new Pelicula(
                            "DATOPRUEBALa vida es bella",
                            "Un clásico de Oscar",
                            1999,
                            Pelicula.emPuntuacion._5,
                            "https://i.imgur.com/psiUtWd.png"
                    ));
            lvh.getLceluloides().add(
                    new Pelicula(
                            "DATOPRUEBALa vida es bella",
                            "Un clásico de Oscar",
                            1999,
                            Pelicula.emPuntuacion._5,
                            "https://i.imgur.com/psiUtWd.png"
                    ));
            lv_adpCelulod.notifyDataSetChanged();


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

}
