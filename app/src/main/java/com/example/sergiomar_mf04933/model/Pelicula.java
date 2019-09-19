package com.example.sergiomar_mf04933.model;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.util.UUID;


/*
curl -S https://ghibliapi.herokuapp.com/films
* [
  {
    "id": "2baf70d1-42bb-4437-b551-e5fed5a87abe",
    "title": "Castle in the Sky",
    "description": "The orphan Sheeta inherited a mysterious crystal that links her to the mythical sky-kingdom of Laputa. With the help of resourceful Pazu and a rollicking band of sky pirates, she makes her way to the ruins of the once-great civilization. Sheeta and Pazu must outwit the evil Muska, who plans to use Laputa's science to make himself ruler of the world.",
    "director": "Hayao Miyazaki",
    "producer": "Isao Takahata",
    "release_date": "1986",
    "rt_score": "95",
    "people": [
      "https://ghibliapi.herokuapp.com/people/"
    ],
    "species": [
      "https://ghibliapi.herokuapp.com/species/af3910a6-429f-4c74-9ad5-dfe1c4aa04f2"
    ],
    "locations": [
      "https://ghibliapi.herokuapp.com/locations/"
    ],
    "vehicles": [
      "https://ghibliapi.herokuapp.com/vehicles/"
    ],
    "url": "https://ghibliapi.herokuapp.com/films/2baf70d1-42bb-4437-b551-e5fed5a87abe"
  },
  {
    "id": "12cfb892-aac0-4c5b-94af-521852e46d6a",
    "title": "Grave of the Fireflies",
    "description": "In the latter part of World War II, a boy and his sister, orphaned when their mother is killed in the firebombing of Tokyo, are left to survive on their ow
* */

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
