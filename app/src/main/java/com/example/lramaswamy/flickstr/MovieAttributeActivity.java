package com.example.lramaswamy.flickstr;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.lramaswamy.flickstr.models.Movie;

public class MovieAttributeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_attribute);
        Movie movieDetails = getIntent().getParcelableExtra("movieDetails");

        populateMovieAttribute(movieDetails, getApplicationContext());
    }

    private void populateMovieAttribute(Movie movieDetails, Context applicationContext) {
        TextView movieTitle = (TextView) findViewById(R.id.movieTitle);
        TextView movieOverview = (TextView) findViewById(R.id.movieSynopsis);

        movieTitle.setText(movieDetails.getOriginalTitle());
        movieOverview.setText(movieDetails.getOverview());

        ImageView movieRatings = (ImageView) findViewById(R.id.movieRating);
        movieRatings.setImageResource(R.mipmap.fivestars);
    }


}
