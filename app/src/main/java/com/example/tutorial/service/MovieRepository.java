package com.example.tutorial.service;

import com.example.tutorial.model.movie.MovieDiscoverResponse;

import retrofit2.Call;
import retrofit2.http.GET;

public interface MovieRepository {
    @GET("3/discover/movie?api_key=04b48d4b070926834c81fa0168ab1bf8")
    Call<MovieDiscoverResponse> getMovieDiscover();
}
