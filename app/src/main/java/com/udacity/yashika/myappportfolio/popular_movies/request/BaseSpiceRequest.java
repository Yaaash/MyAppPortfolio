package com.udacity.yashika.myappportfolio.popular_movies.request;

import com.octo.android.robospice.request.retrofit.RetrofitSpiceRequest;

/**
 * @author yashika.
 */
public abstract class BaseSpiceRequest<T,V> extends RetrofitSpiceRequest<T, V> implements CacheAbleRequest {

    public BaseSpiceRequest(Class<T> clazz, Class<V> retrofitedInterfaceClass) {
        super(clazz, retrofitedInterfaceClass);
    }
}
