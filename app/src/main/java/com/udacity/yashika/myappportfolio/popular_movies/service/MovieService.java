package com.udacity.yashika.myappportfolio.popular_movies.service;

import android.app.Application;
import android.text.method.MovementMethod;

import com.octo.android.robospice.persistence.CacheManager;
import com.octo.android.robospice.persistence.exception.CacheCreationException;
import com.udacity.yashika.myappportfolio.popular_movies.PopularMoviesUtils;
import com.udacity.yashika.myappportfolio.popular_movies.request.MovieRequestManager;
import com.udacity.yashika.myappportfolio.popular_movies.utils.BaseRequestInterceptor;

/**
 * @author yashika.
 */
public class MovieService extends BaseSpiceService<MovieRequestManager> {

    private CacheManager cacheManager;

    @Override
    public void onCreate() {
        requestInterceptor = new BaseRequestInterceptor();
        cacheManager = new CacheManager();
        super.onCreate();
        addRequestManger(MovieRequestManager.class);
    }

    @Override
    public CacheManager createCacheManager(Application application) throws CacheCreationException {
        return cacheManager;
    }

    @Override
    protected String getServerURL() {
        return PopularMoviesUtils.baseUrl();
    }
}
