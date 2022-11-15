package com.example.javaandroid.API;

import static com.example.javaandroid.Constantes.Constantes.BASE_URL;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Service {

    private static Retrofit.Builder retrofitBuilder =
            new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create());

    private static Retrofit retrofit = retrofitBuilder.build();

    private static EstudioApi estudioApi = retrofit.create(EstudioApi.class);

    public static EstudioApi getEstudioApi(){
        return estudioApi;
    }

}

