package com.udacity.yashika.myappportfolio.popular_movies.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * @author yashika.
 */
public class MovieResponse implements Serializable {

    @SerializedName("page")
    private String currentPage;
    @SerializedName("results")
    private ArrayList<Movie> movies;
    @SerializedName("total_results")
    private String totalResults;
    @SerializedName("total_pages")
    private String totalPages;

    public String getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(String currentPage) {
        this.currentPage = currentPage;
    }

    public ArrayList<Movie> getMovies() {
        return movies;
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

}
