package com.udacity.yashika.myappportfolio.popular_movies.utils;

import retrofit.RequestInterceptor;

/**
 * @author yashika.
 */
public class BaseRequestInterceptor implements RequestInterceptor {

    private static final String CONTENT_TYPE = "Content-Type";
    private static final String APPLICATION_JSON = "application/json";

    @Override
    public void intercept(RequestFacade request) {
        request.addHeader(CONTENT_TYPE, APPLICATION_JSON);
    }
}
