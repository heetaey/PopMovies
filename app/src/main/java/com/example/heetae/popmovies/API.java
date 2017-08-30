package com.example.heetae.popmovies;

import retrofit.Callback;
import retrofit.http.GET;
import retrofit.http.Path;
import retrofit.http.Query;

public interface API {
    @GET("/movie/popular")
    void getPopularMovies(Callback<Movie.MovieResult> cb);

    @GET("/movie/{id}")
    void movieDetails(Callback<Movie.MovieResult> cb);

}


