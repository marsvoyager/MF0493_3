package com.example.sergiomar_mf04933.retrofit;

import com.example.sergiomar_mf04933.model.PeliculaGhibli;

import java.util.List;

import retrofit.Call;
import retrofit.http.Body;
import retrofit.http.DELETE;
import retrofit.http.GET;
import retrofit.http.POST;
import retrofit.http.Path;

public interface Service {
    @GET("/films")
    Call<List<PeliculaGhibli>> listGhiblis();

    /*@GET("users/")
    Call<List<Persona>> listPersonas();

    @DELETE("users/{user_id}")
    Call<Void> deleteUser(@Path("user_id") long user_id);

    @POST("users/")
    Call<Persona> saveUser(@Body Persona user);*/

}
