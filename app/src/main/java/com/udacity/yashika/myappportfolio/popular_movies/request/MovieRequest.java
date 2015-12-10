package com.udacity.yashika.myappportfolio.popular_movies.request;

import com.udacity.yashika.myappportfolio.popular_movies.model.MovieRequestBody;
import com.udacity.yashika.myappportfolio.popular_movies.model.MovieResponse;

/**
 * @author yashika.
 */
public class MovieRequest extends BaseSpiceRequest<MovieResponse, MovieRequestManager> {

    // This is the body that is used for the login request.
    private MovieRequestBody movieRequestBody;

    // Hold cache for 5 minutes
    private static final long FIVE_MINUTES = 5 * 60 * 1000;

    /**
     * This is the constructor that is used to create the discover movie request.
     * @param apiKey - the movie database api key
     */
    public MovieRequest(String apiKey) {
        super(MovieResponse.class, MovieRequestManager.class);
        movieRequestBody = new MovieRequestBody();
//        movieRequestBody.setApiKey(apiKey);
    }

    @Override
    public Object getCacheKey() {
        return String.valueOf(this.hashCode() + System.currentTimeMillis() / FIVE_MINUTES);
    }

    @Override
    public MovieResponse loadDataFromNetwork() throws Exception {
        return getService().getMovieRequest();
    }
}