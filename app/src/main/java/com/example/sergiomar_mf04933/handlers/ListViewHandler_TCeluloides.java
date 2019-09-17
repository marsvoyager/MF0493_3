package com.example.sergiomar_mf04933.handlers;

import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.sergiomar_mf04933.MainActivity;
import com.example.sergiomar_mf04933.adapter.CustomAdapterCeluloides;
import com.example.sergiomar_mf04933.helper.HelperFactory;
import com.example.sergiomar_mf04933.helper.ICallback;
import com.example.sergiomar_mf04933.model.Pelicula;

import java.util.ArrayList;


public class ListViewHandler_TCeluloides
        implements HelperFactory.Params{

    public interface ListViewHandlerFactory
            extends HelperFactory
    {
    };

    public interface callBackItemClickFactory
            extends HelperFactory
    {
    }


    ArrayList<Pelicula> lceluloides=null;//= new ArrayList<Destination>();
    ListView lv_celuloides;
    CustomAdapterCeluloides lv_adpCelulod;

    public CustomAdapterCeluloides getLv_adpCelulod() {
        return lv_adpCelulod;
    }

    public void setLv_adpCelulod(CustomAdapterCeluloides lv_adpCelulod) {

        this.lv_adpCelulod = lv_adpCelulod;
        lv_celuloides.setAdapter(this.lv_adpCelulod);
    }

    public ListView getLv_celuloides() {
        return lv_celuloides;
    }

    public ArrayList<Pelicula> getLceluloides() {
        return lceluloides;
    }

    public void setLceluloides(ArrayList<Pelicula> lceluloides) {
        this.lceluloides = lceluloides;
    }

    public void setLv_celuloides(ListView lv_celuloides) {
        this.lv_celuloides = lv_celuloides;
    }

    public static class callBackItemClick
            implements AdapterView.OnItemClickListener, ICallback {

        ICallback cblistview = null;
        Intent pintent = null;
        ArrayList<Pelicula> lceluloides;

        public callBackItemClick(ArrayList<Pelicula> lceluloid, MainActivity.PeliculasLVClickCb pclickcb, Intent intPelicDetalle) {
            lceluloides = lceluloid;
            cblistview = pclickcb;
            pintent = intPelicDetalle;
        }

        @Override
        public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
            Pelicula p = lceluloides.get(position);

            pintent.putExtra("peliculaindex", position);
            pintent.putExtra("peliculauuid", p.getId());
            pintent.putExtra("modoEdicion", true);
            /*pintent.putExtra("peliculatitulo", p.getTitulo());
            pintent.putExtra("peliculadesc", p.getDescripcion());
            pintent.putExtra("peliculaany", p.getAnyo_public());
            pintent.putExtra("peliculapunt", p.getPuntuacion());
            pintent.putExtra("peliculaURL", p.getImagenUrl());
            */

            //openDetail(destinations.get(position));
            //Toast.makeText(getApplicationContext(), "click click" , Toast.LENGTH_LONG).show();
            cblistview.response();
        }

        @Override
        public void response() {
        }
    }

    public ListViewHandler_TCeluloides(ArrayList<Pelicula> celuloids,ListView lv_celud, callBackItemClick cbclick) {
        lv_celuloides = lv_celud;

        lceluloides= celuloids;
        lv_celuloides.setOnItemClickListener(cbclick);

    }
}
