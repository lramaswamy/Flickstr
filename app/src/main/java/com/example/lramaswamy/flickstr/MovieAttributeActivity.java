package com.example.lramaswamy.flickstr;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.RatingBar;
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
        RatingBar ratingBar = (RatingBar) findViewById(R.id.ratingBar);
        ImageView moviePopularity = (ImageView) findViewById(R.id.popularity);

        ratingBar.setIsIndicator(true);
        movieTitle.setText(movieDetails.getOriginalTitle());
        movieOverview.setText(movieDetails.getOverview());
        ratingBar.setRating((movieDetails.getRatings()/2));

        int popularity = movieDetails.getPopularity();
        int movieResource;
        if(popularity <= 10)
        {
            movieResource = R.mipmap.thumbs_down_blue;
        } else if(popularity > 10 && popularity < 20) {
            movieResource = R.mipmap.thumbs_up_green;
        } else if(popularity > 20 && popularity < 30) {
            movieResource = R.mipmap.thumbs_up_red;
        } else {
            movieResource = R.mipmap.flaminghot;
        }
        moviePopularity.setImageResource(movieResource);

    }


}
