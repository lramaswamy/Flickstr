package com.example.lramaswamy.flickstr.Adapters;

import android.content.Context;
import android.content.res.Configuration;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.lramaswamy.flickstr.R;
import com.example.lramaswamy.flickstr.models.Movie;
import com.squareup.picasso.Picasso;

import java.util.List;

import jp.wasabeef.picasso.transformations.RoundedCornersTransformation;

/**
 * Created by lramaswamy on 10/11/16.
 */

public class MovieArrayAdapter extends ArrayAdapter<Movie> {


    private static class MovieViewHolder {
        ImageView movieImage;
        TextView tvTitle;
        TextView tvOverview;
    }
    public MovieArrayAdapter(Context context, List<Movie> movies) {
        super(context, android.R.layout.simple_list_item_1, movies);
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Movie movie = getItem(position);

        MovieViewHolder mvViewHolder;
        //If the view is not existing already, then inflate the view
        if (convertView == null) {
            mvViewHolder = new MovieViewHolder();
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_movie, parent, false);
            mvViewHolder.movieImage = (ImageView) convertView.findViewById(R.id.movieImage);
            mvViewHolder.tvTitle = (TextView) convertView.findViewById(R.id.tvTitle);
            mvViewHolder.tvOverview = (TextView) convertView.findViewById(R.id.tvOverview);
            //Store the movie view holder row so that it can be recycled
            convertView.setTag(mvViewHolder);
        } else {
            mvViewHolder = (MovieViewHolder) convertView.getTag();
        }

        //clear out the image is convertView is being reused
        mvViewHolder.movieImage.setImageResource(0);
        int orientation = getContext().getResources().getConfiguration().orientation;
        //Populate the view holder for the movie model with the correct data
        if(orientation == Configuration.ORIENTATION_PORTRAIT)
            Picasso.with(getContext()).load(movie.getPosterPath()).transform(new RoundedCornersTransformation(20, 10)).placeholder(R.mipmap.placeholder).into(mvViewHolder.movieImage);
        else
            Picasso.with(getContext()).load(movie.getBackdropPath()).transform(new RoundedCornersTransformation(20, 10)).placeholder(R.mipmap.placeholder).into(mvViewHolder.movieImage);
        mvViewHolder.tvTitle.setText(movie.getOriginalTitle());
        mvViewHolder.tvOverview.setText(movie.getOverview());

        return convertView;
    }
}
