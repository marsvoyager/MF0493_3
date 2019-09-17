package com.example.sergiomar_mf04933.controller;

import android.content.Context;

import androidx.room.Room;

import com.example.sergiomar_mf04933.database.PeliculaDao;
import com.example.sergiomar_mf04933.database.PeliculaDatabase;
import com.example.sergiomar_mf04933.model.Pelicula;

import java.util.List;

public class PeliculaController {

    private static PeliculaController sTLab;
    private PeliculaDao mTDao;

    private PeliculaController(Context context)
    {
        Context appcontext= context.getApplicationContext();
        PeliculaDatabase database =
                Room.databaseBuilder(
                        appcontext,
                        PeliculaDatabase.class
                        , "pelicula")
                        .allowMainThreadQueries().build();
        mTDao= database.getPeliculaDao();
    }
    public static PeliculaController get(Context context)
    {
        if(sTLab == null){
            sTLab = new PeliculaController(context);
        }
        return sTLab;
    }
    public List<Pelicula> getPeliculas()
    {
        return mTDao.getPeliculas();
    }

    public void addPelicula(Pelicula pelicula) {
        mTDao.addPelicula(pelicula);
    }
    public void delPelicula(Pelicula pelicula) {
        mTDao.deletePelicula(pelicula);
    }
}
