package com.example.sergiomar_mf04933.database;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.example.sergiomar_mf04933.model.Pelicula;

@Database(entities = {Pelicula.class}, version = 1)
public abstract class PeliculaDatabase
extends RoomDatabase {
    public abstract PeliculaDao getPeliculaDao();
}
