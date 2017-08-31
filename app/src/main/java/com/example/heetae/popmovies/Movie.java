package com.example.heetae.popmovies;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;
import java.util.List;

/**
 * Created by hsMacbook on 2017. 8. 29..
 */

public class Movie implements Parcelable{
    private String title;
    @SerializedName("poster_path")
    private String poster;
    @SerializedName("overview")
    private String description;
    @SerializedName("backdrop_path")
    private String backdrop;
    @SerializedName("vote_average")
    private String rating;
    @SerializedName("release_date")
    private String releaseDate;

    protected Movie(Parcel in){
        title = in.readString();
        poster = in.readString();
        description = in.readString();
        backdrop = in.readString();
        rating = in.readString();
        releaseDate = in.readString();
    }

    public static final Parcelable.Creator<Movie> CREATOR
            = new Parcelable.Creator<Movie>() {
        @Override
        public Movie createFromParcel (Parcel in) {
            return new Movie(in);
        }

        @Override
        public Movie[] newArray (int size) {
            return new Movie[size];
        }
    };

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPoster() {
        return "http://image.tmdb.org/t/p/w500/" + poster;
    }

    public void setPoster(String poster) {
        this.poster = poster;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getBackdrop() {
        return "http://image.tmdb.org/t/p/w500/" + backdrop;
    }

    public void setBackdrop(String backdrop) {
        this.backdrop = backdrop;
    }

    public String getRating() {
        return "Ratings: " + rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getReleaseDate() {
        return "Release date: " + releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(title);
        parcel.writeString(poster);
        parcel.writeString(description);
        parcel.writeString(backdrop);
        parcel.writeString(rating);
        parcel.writeString(releaseDate);
    }

    public static class MovieResult {
        private List<Movie> results;
        public List<Movie> getResults() {
            return results;
        }
    }
}
