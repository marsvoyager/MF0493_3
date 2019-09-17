package com.example.sergiomar_mf04933.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.sergiomar_mf04933.R;
import com.example.sergiomar_mf04933.model.Pelicula;

import java.util.ArrayList;

public class CustomAdapterCeluloides
        extends ArrayAdapter<Pelicula> {

    int layoutResourceId;
    Context context;
    ArrayList<Pelicula> celuloides;

    public CustomAdapterCeluloides(Context _context, int layoutResourceId,
                                   ArrayList<Pelicula> _data) {
        super(_context, layoutResourceId, _data);

        this.layoutResourceId=layoutResourceId;
        this.context=_context;
        this.celuloides = _data;
    }

    public ArrayList<Pelicula> getCeluloides() {
        return celuloides;
    }

    public void setCeluloides(ArrayList<Pelicula> celuloides) {
        this.celuloides = celuloides;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View row;
        LayoutInflater inflater = ((Activity) context).getLayoutInflater();

        row = inflater.inflate(layoutResourceId, parent, false);
        TextView tvtitpelic = (TextView)row.findViewById(R.id.tvrow_celutitulid);
        TextView tvpuntpelic = (TextView)row.findViewById(R.id.tvrow_celupuntid);

        Pelicula pelic = celuloides.get(position);
        if( (null == pelic.getTitulo() )
          || (null == pelic.getPuntuacion())
        )
                  return row;

        tvtitpelic.setText(pelic.getTitulo());

        tvpuntpelic.setText(""+pelic.getPuntuacion());
        switch(pelic.getPuntuacion()){
            case 0:
                case 1:
                    tvpuntpelic.setTextColor(context.getResources().getColor(R.color.colorpunt1));
                    break;
            case 2:
            case 3:
                tvpuntpelic.setTextColor(context.getResources().getColor(R.color.colorpunt2));
                break;
            default:
                tvpuntpelic.setTextColor(context.getResources().getColor(R.color.colorpunt3));

        }

        return row;
    }

}
