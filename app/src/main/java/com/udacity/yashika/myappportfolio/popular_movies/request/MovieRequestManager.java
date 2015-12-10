package com.udacity.yashika.myappportfolio.popular_movies.request;

import com.udacity.yashika.myappportfolio.popular_movies.model.MovieRequestBody;
import com.udacity.yashika.myappportfolio.popular_movies.model.MovieResponse;

import retrofit.http.Body;
import retrofit.http.GET;
import retrofit.http.POST;

/**
 * @author yashika.
 */
public interface MovieRequestManager {

    /**
     * This is the method that is used to make the post call to make the movie request.
     *
     * @return An object of MovieResponse.
     */
    @GET("/discover/movie?api_key=2a558c0aa900e0db7e502f10595635e9")
    MovieResponse getMovieRequest();

}
