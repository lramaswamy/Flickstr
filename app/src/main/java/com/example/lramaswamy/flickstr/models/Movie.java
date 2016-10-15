package com.example.lramaswamy.flickstr.models;

import android.os.Parcel;
import android.os.Parcelable;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by lramaswamy on 10/10/16.
 */

public class Movie implements Parcelable {
    String posterPath;
    String backdropPath;
    String originalTitle;
    String overview;
    float ratings;
    int popularity;
    int movieID;

    static String api_key="a07e22bc18f5cb106bfe4cc1f83ad8ed";

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

    public float getRatings() {
        return ratings;
    }

    public int getPopularity() {
        return popularity;
    }

    public int getMovieID() {
        return movieID;
    }


    public Movie(JSONObject jsonObject) throws JSONException {

        this.posterPath = jsonObject.getString("poster_path");
        this.backdropPath = jsonObject.getString("backdrop_path");
        this.originalTitle = jsonObject.getString("original_title");
        this.overview = jsonObject.getString("overview");
        this.popularity = jsonObject.getInt("popularity");
        this.ratings = jsonObject.getLong("vote_average");
        this.movieID = jsonObject.getInt("id");
    }

    private Movie(Parcel in) {
        this.posterPath = in.readString();
        this.backdropPath = in.readString();
        this.originalTitle = in.readString();
        this.overview = in.readString();
        this.ratings = in.readFloat();
        this.popularity = in.readInt();
    }

    public static ArrayList<Movie> fromJSONArray(JSONArray array) {
        ArrayList<Movie> results = new ArrayList<>();

        for (int i = 0; i < array.length(); i++) {
            try {
                results.add(new Movie(array.getJSONObject(i)));
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return results;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(posterPath);
        dest.writeString(backdropPath);
        dest.writeString(originalTitle);
        dest.writeString(overview);
        dest.writeFloat(ratings);
        dest.writeInt(popularity);
    }

    public static final Parcelable.Creator<Movie> CREATOR = new Creator<Movie>() {
        @Override
        public Movie createFromParcel(Parcel source) {
            return new Movie(source);
        }

        @Override
        public Movie[] newArray(int size) {
            return new Movie[size];
        }
    };

    /*public void getRatingsFromAPI() {
        String url = "https://api.themoviedb.org/3/movie/" + movieID + "/account_states?" + api_key;

        AsyncHttpClient client = new AsyncHttpClient();
        client.get(url, new JsonHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
                JSONArray results = null;
                try {
                    results = response.getJSONArray("results");
                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }

            @Override
            public void onFailure(int statusCode, Header[] headers, String responseString, Throwable throwable) {
                super.onFailure(statusCode, headers, responseString, throwable);
            }
        });
    }*/
}
