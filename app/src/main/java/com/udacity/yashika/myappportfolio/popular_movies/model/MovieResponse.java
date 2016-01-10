package com.udacity.yashika.myappportfolio.popular_movies.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * @author yashika.
 */
public class MovieResponse implements Parcelable {

    public static final Creator<MovieResponse> CREATOR = new Creator<MovieResponse>() {
        @Override
        public MovieResponse createFromParcel(Parcel in) {
            return new MovieResponse(in);
        }

        @Override
        public MovieResponse[] newArray(int size) {
            return new MovieResponse[size];
        }
    };
    @SerializedName("page")
    private String currentPage;
    @SerializedName("results")
    private ArrayList<Movie> movies;
    @SerializedName("total_results")
    private String totalResults;
    @SerializedName("total_pages")
    private String totalPages;

    protected MovieResponse(Parcel in) {
        currentPage = in.readString();
        movies = in.createTypedArrayList(Movie.CREATOR);
        totalResults = in.readString();
        totalPages = in.readString();
    }

    public String getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(String currentPage) {
        this.currentPage = currentPage;
    }

    public ArrayList<Movie> getMovies() {
        if(movies != null) {
            return movies;
        }
        return new ArrayList<>();
    }

    public void setMovies(ArrayList<Movie> movies) {
        this.movies = movies;
    }

    public String getTotalResults() {
        return totalResults;
    }

    public void setTotalResults(String totalResults) {
        this.totalResults = totalResults;
    }

    public String getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(String totalPages) {
        this.totalPages = totalPages;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(currentPage);
        dest.writeTypedList(movies);
        dest.writeString(totalResults);
        dest.writeString(totalPages);
    }
}
