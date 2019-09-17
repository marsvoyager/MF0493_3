package com.example.sergiomar_mf04933.database;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.sergiomar_mf04933.model.Pelicula;

import java.util.List;

@Dao
public interface PeliculaDao {
    @Query("SELECT * FROM pelicula")
    List<Pelicula> getPeliculas();

    @Insert
    void addPelicula(Pelicula pelicula);

    @Delete
    void deletePelicula(Pelicula pel);
}
