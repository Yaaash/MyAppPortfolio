package com.udacity.yashika.myappportfolio.popular_movies;

import com.udacity.yashika.myappportfolio.AppPortfolioApplication;
import com.udacity.yashika.myappportfolio.popular_movies.model.Movie;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * @author yashika.
 */
public class PopularMoviesUtils {

    public static final boolean DEBUGGABLE = true;
    public static final String TAG = AppPortfolioApplication.class.getSimpleName();
    public static final String MOVIE_API_KEY = "2a558c0aa900e0db7e502f10595635e9";
    public static final String IMAGE_BASE_URL = "http://image.tmdb.org/t/p/";

    public static final String ORIGINAL = "original/";
    public static final String W185 = "w185/";

    public static String baseUrl() {
        String baseUrl = "";
        if(DEBUGGABLE) {
            baseUrl = "http://api.themoviedb.org/3";
        } else {
            //TODO: need to know base URL for release/ other configs
        }
        return baseUrl;
    }

    public static ArrayList<Movie> sortMoviesByPopularity(ArrayList<Movie> movies) {
        Collections.sort(movies, new MoviePopularityComparator());
        return movies;
    }

    public static ArrayList<Movie> sortMoviesByHighestRating(ArrayList<Movie> movies) {
        Collections.sort(movies, new MovieRatingComparator());
        return movies;
    }

    /**
     * This comparator compares two employees by their ages.
     *
     * @author www.codejava.net
     */
    public static class MoviePopularityComparator implements Comparator<Movie> {

        @Override
        public int compare(Movie movie1, Movie movie2) {
            if (movie1.getPopularity() > movie2.getPopularity()) {
                return 1;
            }
            else if (movie1.getPopularity() <  movie2.getPopularity()) {
                return -1;
            }
            else {
                return 0;
            }
        }
    }

    /**
     * This comparator compares two employees by their ages.
     *
     * @author www.codejava.net
     */
    public static class MovieRatingComparator implements Comparator<Movie> {

        @Override
        public int compare(Movie movie1, Movie movie2) {
            if (movie1.getAverageVote() > movie2.getAverageVote()) {
                return 1;
            }
            else if (movie1.getAverageVote() <  movie2.getAverageVote()) {
                return -1;
            }
            else {
                return 0;
            }
        }
    }
}