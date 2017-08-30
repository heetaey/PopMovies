package com.example.heetae.popmovies;

import retrofit.Callback;
import retrofit.http.GET;

public interface API {
    @GET("/movie/popular")
    void getPopularMovies(Callback<Movie.MovieResult> cb);
}


