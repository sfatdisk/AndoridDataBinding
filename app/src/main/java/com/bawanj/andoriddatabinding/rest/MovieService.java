package com.bawanj.andoriddatabinding.rest;


import com.bawanj.andoriddatabinding.model.MoviesByDate;

import java.util.List;

import retrofit.Callback;
import retrofit.http.GET;

/*This interface will hold our API declaration
* to work with Retrofit library. Basically it's
* just mimicking our REST api. Here we've just
* created a method signature which gives us
* a list of movies in the Callback provided
* by Retrofit*/

public interface MovieService {
    @GET("/comingSoon")
    void getComingSoonMovies( Callback<List<MoviesByDate>> movies);
}
