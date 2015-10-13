package com.bawanj.andoriddatabinding.activity;


import android.databinding.DataBindingUtil;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;

import com.bawanj.andoriddatabinding.R;
import com.bawanj.andoriddatabinding.adapter.MovieAdapter;
import com.bawanj.andoriddatabinding.databinding.ActivityMovieBinding;
import com.bawanj.andoriddatabinding.model.Movie;
import com.bawanj.andoriddatabinding.model.MoviesByDate;
import com.bawanj.andoriddatabinding.rest.MovieService;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class MovieActivity extends AppCompatActivity {

    private final static String TAG="MovieActivity";
    private final static String BASE_URL= "http://www.myapifilms.com/imdb";

    private List<Movie> mMovies;
    private MovieAdapter mMovieAdapter;
    private ActivityMovieBinding binding;

    @Override
    protected void onCreate( Bundle savedInstanceState ){
        super.onCreate(savedInstanceState);

        binding = DataBindingUtil
                .setContentView(this, R.layout.activity_movie);

        binding.movieToolbar.setTitle("Movie Activity");
        binding.movieToolbar.setTitleTextColor(Color.WHITE);
        setSupportActionBar(binding.movieToolbar);

        Picasso.with(getApplicationContext())
                .setIndicatorsEnabled(true);

        mMovies= new ArrayList<>();
        mMovieAdapter = new MovieAdapter(mMovies);
        binding.movieRecyclerView.setAdapter(mMovieAdapter);

        binding.movieRecyclerView
                .setLayoutManager(new LinearLayoutManager(this));

        fetchComingSoonMovies();

    }
// similar to volley JSONRequest
    private void fetchComingSoonMovies() {
    // whole API: http://www.myapifilms.com/imdb + /comingSoon

        RestAdapter restAdapter = // create a restAdapter
                new RestAdapter.Builder()
                        .setEndpoint(BASE_URL)
                        .build();

        MovieService movieService
                = restAdapter.create( MovieService.class );

        movieService.getComingSoonMovies(new Callback<List<MoviesByDate> >() {
            @Override
            public void success(List<MoviesByDate> moviesByDates
                    , Response response) {
                Log.d(TAG, "JSON Response ? "+ response );
                // initialize the adapter
                for(MoviesByDate item: moviesByDates ){
                    mMovies.addAll( item.getMovies() );
                }

                mMovieAdapter.notifyDataSetChanged();
            }

            @Override
            public void failure(RetrofitError error) {
                Log.d( TAG,"retrofit Cannot fetch IMDB data" );
                error.printStackTrace();
            }
        });
    }
}
