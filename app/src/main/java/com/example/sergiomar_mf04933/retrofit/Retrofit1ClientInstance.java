package com.example.sergiomar_mf04933.retrofit;

import retrofit.GsonConverterFactory;
import retrofit.Retrofit;

public class Retrofit1ClientInstance {

    private static Retrofit retrofit;

    private static final String BASE_URL = "https://ghibliapi.herokuapp.com/films";

    public static Retrofit getRetrofitInstance() {

        if (retrofit == null) {

            //retrofit = new retrofit2.Retrofit.Builder()
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }

        return retrofit;
    }
}
