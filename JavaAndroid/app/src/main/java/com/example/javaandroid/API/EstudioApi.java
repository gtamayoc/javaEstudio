package com.example.javaandroid.API;

import com.example.javaandroid.API.responses.EstudioApiResponse;
import com.example.javaandroid.API.responses.LoginResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface EstudioApi {
    //busqueda de la pelicula
    //https://api.themoviedb.org/3/search/movie?api_key={api_key}&query=Jack+Reacher
    //https://api.themoviedb.org/3/search/movie?api_key={api_key}&query=Jack+Reacher


    @GET("3/search/movie")
    Call<EstudioApiResponse> searchMovie(@Query("api_key") String key);

    @GET("/login")
    Call<LoginResponse> Login();

    @GET("/login/{user}&{pass}?")
    Call<LoginResponse> loginPass(
            @Path("user") String user,
            @Path("pass") String pass
    );

    @POST("/login/{user}&{pass}?")
    Call<LoginResponse> loginPass1(
            @Path("user") String user,
            @Path("pass") String pass
    );

    @GET("3/movie/{movie_id}?")
    Call<EstudioApiResponse> getMovie(
            @Path("movie_id") int movie_id,
            @Query("api_key") String api_key
    );


}
