package com.example.sergiomar_mf04933.model;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.util.UUID;

@Entity(tableName="pelicula")
public class Pelicula {

    //NOT USED!!
    public enum emPuntuacion
    {_0(0), _1(1), _2(2), _3(3), _4(4),
        _5(5),
        ;
        private int punt;

        emPuntuacion(int i) {
            punt = i;
        }

        public int getPunt() {
            return punt;
        }

        @Override
        public String toString() {
            //return super.toString();
            return ""+punt;
        }

    };


    @PrimaryKey
    @NonNull
    private String id;

    @ColumnInfo(name = "titulo")
    private String titulo;

    @ColumnInfo(name = "desc")
    private String descripcion;

    @ColumnInfo(name = "any_public")
    private String anyo_public;

    @ColumnInfo(name = "puntuacio")
    private Integer puntuacion;
    //private emPuntuacion empuntuacion;

    @ColumnInfo(name = "img_url")
    private String imagenUrl;


    @NonNull
    public String getId() {
        return id;
    }

    public void setId(@NonNull String id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getAnyo_public() {
        return anyo_public;
    }

    public void setAnyo_public(String anyo_public) {
        this.anyo_public = anyo_public;
    }

    /*public emPuntuacion getPuntuacion() {
        return puntuacion;
    }

    public void setPuntuacion(emPuntuacion puntuacion) {
        this.puntuacion = puntuacion;
    }*/

    public Integer getPuntuacion() {
        return puntuacion;
    }

    public void setPuntuacion(Integer puntuacion) {
        this.puntuacion = puntuacion;
    }

    public String getImagenUrl() {
        return imagenUrl;
    }

    public void setImagenUrl(String imagenUrl) {
        this.imagenUrl = imagenUrl;
    }
    public Pelicula(String messag) {
        this.id= UUID.randomUUID().toString();

    }

    public Pelicula() {
        this.id=UUID.randomUUID().toString();
    }
    public Pelicula(String titu, String desc,
                    String anyp, emPuntuacion emPuntuacion,
                    String simgurl) {
        this.id= UUID.randomUUID().toString();
        this.titulo=titu;
        this.descripcion=desc;
        this.anyo_public=anyp;
        this.puntuacion = emPuntuacion.getPunt();
        this.imagenUrl = simgurl;
    }


}
