package com.thomaskioko.tmdbmovies.adapter;


import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.thomaskioko.tmdbmovies.R;
import com.thomaskioko.tmdbmovies.models.Result;

import java.util.List;

/**
 * This class is responsible for styling items in the RecyclerView.
 *
 * @author Thomas Kioko
 */

public class MoviesAdapter extends RecyclerView.Adapter<MoviesAdapter.MyViewHolder> {

    private List<Result> moviesList;
    private String posterPath = "http://image.tmdb.org/t/p/w500/";

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView title, year, genre;
        public ImageView posterImageView;

        public MyViewHolder(View view) {
            super(view);
            title = (TextView) view.findViewById(R.id.title);
            genre = (TextView) view.findViewById(R.id.genre);
            year = (TextView) view.findViewById(R.id.year);
            posterImageView = (ImageView) view.findViewById(R.id.image_view_poster);
        }
    }

    public MoviesAdapter(List<Result> moviesList) {
        this.moviesList = moviesList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.movie_list_row, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Result movie = moviesList.get(position);
        holder.title.setText(movie.getTitle());
        holder.genre.setText(movie.getOverview());
        holder.year.setText(movie.getReleaseDate());
    }

    @Override
    public int getItemCount() {
        return moviesList.size();
    }
}
