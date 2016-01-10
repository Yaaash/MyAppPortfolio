package com.udacity.yashika.myappportfolio.popular_movies.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * This class is used to as model class for Movie object
 *
 * @author yashika.
 */
public class Movie implements Parcelable {

    public static final Creator<Movie> CREATOR = new Creator<Movie>() {
        @Override
        public Movie createFromParcel(Parcel in) {
            return new Movie(in);
        }

        @Override
        public Movie[] newArray(int size) {
            return new Movie[size];
        }
    };
    @SerializedName("poster_path")
    private String moviePoster;
    @SerializedName("adult")
    private String adult;
    @SerializedName("overview")
    private String movieOverview;
    @SerializedName("release_date")
    private String releaseDate;
    @SerializedName("genre_ids")
    private ArrayList<Integer> genreIds;
    @SerializedName("id")
    private int movieID;
    @SerializedName("original_title")
    private String originalMovieTitle;
    @SerializedName("original_language")
    private String originalMovieLang;
    @SerializedName("title")
    private String movieTitle;
    @SerializedName("backdrop_path")
    private String movieBackdrop;
    @SerializedName("popularity")
    private String popularity;
    @SerializedName("vote_count")
    private String voteCount;
    @SerializedName("video")
    private String video;
    @SerializedName("vote_average")
    private String averageVote;

    protected Movie(Parcel in) {
        moviePoster = in.readString();
        adult = in.readString();
        movieOverview = in.readString();
        releaseDate = in.readString();
        movieID = in.readInt();
        originalMovieTitle = in.readString();
        originalMovieLang = in.readString();
        movieTitle = in.readString();
        movieBackdrop = in.readString();
        popularity = in.readString();
        voteCount = in.readString();
        video = in.readString();
        averageVote = in.readString();
        genreIds = (ArrayList<Integer>) in.readSerializable();
    }

    public String getMoviePoster() {
        return moviePoster;
    }

    public void setMoviePoster(String moviePoster) {
        this.moviePoster = moviePoster;
    }

    public String isAdult() {
        return adult;
    }

    public void setAdult(String adult) {
        this.adult = adult;
    }

    public String getMovieOverview() {
        return movieOverview;
    }

    public void setMovieOverview(String movieOverview) {
        this.movieOverview = movieOverview;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public ArrayList<Integer> getGenreIds() {
        if(genreIds != null) {
            return genreIds;
        }
        return new ArrayList<>();
    }

    public void setGenreIds(ArrayList<Integer> genreIds) {
        this.genreIds = genreIds;
    }

    public int getMovieID() {
        return movieID;
    }

    public void setMovieID(int movieID) {
        this.movieID = movieID;
    }

    public String getOriginalMovieTitle() {
        return originalMovieTitle;
    }

    public void setOriginalMovieTitle(String originalMovieTitle) {
        this.originalMovieTitle = originalMovieTitle;
    }

    public String getOriginalMovieLang() {
        return originalMovieLang;
    }

    public void setOriginalMovieLang(String originalMovieLang) {
        this.originalMovieLang = originalMovieLang;
    }

    public String getMovieTitle() {
        return movieTitle;
    }

    public void setMovieTitle(String movieTitle) {
        this.movieTitle = movieTitle;
    }

    public String getMovieBackdrop() {
        return movieBackdrop;
    }

    public void setMovieBackdrop(String movieBackdrop) {
        this.movieBackdrop = movieBackdrop;
    }

    public String getPopularity() {
        return popularity;
    }

    public void setPopularity(String popularity) {
        this.popularity = popularity;
    }

    public String getVoteCount() {
        return voteCount;
    }

    public void setVoteCount(String voteCount) {
        this.voteCount = voteCount;
    }

    public String isVideo() {
        return video;
    }

    public void setVideo(String video) {
        this.video = video;
    }

    public String getAverageVote() {
        return averageVote;
    }

    public void setAverageVote(String averageVote) {
        this.averageVote = averageVote;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(moviePoster);
        dest.writeString(adult);
        dest.writeString(movieOverview);
        dest.writeString(releaseDate);
        dest.writeInt(movieID);
        dest.writeString(originalMovieTitle);
        dest.writeString(originalMovieLang);
        dest.writeString(movieTitle);
        dest.writeString(movieBackdrop);
        dest.writeString(popularity);
        dest.writeString(voteCount);
        dest.writeString(video);
        dest.writeString(averageVote);
        dest.writeSerializable(genreIds);
    }
}
