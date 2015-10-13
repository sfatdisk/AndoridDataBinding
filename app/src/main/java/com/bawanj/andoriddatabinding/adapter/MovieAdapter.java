package com.bawanj.andoriddatabinding.adapter;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bawanj.andoriddatabinding.BR;
import com.bawanj.andoriddatabinding.R;
import com.bawanj.andoriddatabinding.model.Movie;

import java.util.List;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.MovieHolder> {

    private List<Movie> mMovies;

    public MovieAdapter(List<Movie> movies){
        mMovies= movies;
    }

    public class MovieHolder extends RecyclerView.ViewHolder {

        private ViewDataBinding binding;

        public MovieHolder(View itemView) {
            super(itemView);
            binding= DataBindingUtil.bind(itemView);
        }

        public ViewDataBinding getBinding(){
            return binding;
        }

    }

    @Override
    public MovieHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View itemView
                = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.movie_item, parent, false);

        return new MovieHolder(itemView);
    }

    @Override
    public void onBindViewHolder( MovieHolder holder, int position) {
        final Movie movie= mMovies.get(position);
        holder.getBinding().setVariable( BR.movie, movie);
        // a resource file BR similar to R is auto generated
        // which provides id for appropriate model to map
        holder.getBinding().executePendingBindings();
        // immediate reflection of the data change in the screen
        // we've called executePendingBinding which forcefully bind
        // the data to view to reflect the change immediately.
    }

    @Override
    public int getItemCount() {
        return mMovies.size() ;
    }

}
