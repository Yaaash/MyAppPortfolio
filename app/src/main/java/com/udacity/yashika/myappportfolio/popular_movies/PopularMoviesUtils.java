package com.udacity.yashika.myappportfolio.popular_movies;

import com.udacity.yashika.myappportfolio.AppPortfolioApplication;

/**
 * @author yashika.
 */
public class PopularMoviesUtils {

    public static final boolean DEBUGGABLE = true;
    public static final String TAG = AppPortfolioApplication.class.getSimpleName();
    private static final String MOVIE_API_KEY = "2a558c0aa900e0db7e502f10595635e9";

    public static String baseUrl() {
        String baseUrl = "";
        if(DEBUGGABLE) {
            baseUrl = "http://api.themoviedb.org/3";
        } else {
            //TODO: need to know base URL for release/ other configs
        }
        return baseUrl;
    }
}