package com.example.lramaswamy.flickstr.models;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by lramaswamy on 10/10/16.
 */

public class Movie {

    public String getPosterPath() {
        return String.format("https://image.tmdb.org/t/p/w780/%s", posterPath);
    }

    public String getBackdropPath() {
        return String.format("https://image.tmdb.org/t/p/w1280/%s", backdropPath);
    }

    public String getOriginalTitle() {
        return originalTitle;
    }

    public String getOverview() {
        return overview;
    }

    String posterPath;
    String backdropPath;
    String originalTitle;
    String overview;

    public Movie(JSONObject jsonObject) throws JSONException {

        this.posterPath = jsonObject.getString("poster_path");
        this.backdropPath = jsonObject.getString("backdrop_path");
        this.originalTitle = jsonObject.getString("original_title");
        this.overview = jsonObject.getString("overview");
    }

    public static ArrayList<Movie> fromJSONArray(JSONArray array) {
        ArrayList<Movie> results = new ArrayList<>();

        for(int i=0; i< array.length(); i++) {
            try {
                results.add(new Movie(array.getJSONObject(i)));
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return results;
    }
}
