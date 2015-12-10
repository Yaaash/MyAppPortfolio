package com.udacity.yashika.myappportfolio.popular_movies.service;

import android.app.Application;
import android.app.Notification;

import com.google.gson.ExclusionStrategy;
import com.google.gson.FieldAttributes;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.octo.android.robospice.SpiceService;
import com.octo.android.robospice.persistence.CacheManager;
import com.octo.android.robospice.persistence.exception.CacheCreationException;
import com.octo.android.robospice.persistence.retrofit.RetrofitObjectPersisterFactory;
import com.octo.android.robospice.request.CachedSpiceRequest;
import com.octo.android.robospice.request.listener.RequestListener;
import com.octo.android.robospice.request.retrofit.RetrofitSpiceRequest;
import com.udacity.yashika.myappportfolio.popular_movies.PopularMoviesUtils;
import com.udacity.yashika.myappportfolio.popular_movies.utils.BaseRequestInterceptor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import retrofit.ErrorHandler;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Client;
import retrofit.client.OkClient;
import retrofit.converter.Converter;
import retrofit.converter.GsonConverter;

/**
 * @author yashika.
 */
public class BaseSpiceService<T> extends SpiceService {

    private RestAdapter restAdapter;
    private RestAdapter.Builder builder;

    private Converter converter;

    private Map<Class<?>, Object> requestManagerToServiceMap = new HashMap<>();

    private List<Class<?>> requestManagerList = new ArrayList<>();

    protected BaseRequestInterceptor requestInterceptor;

    protected ErrorHandler errorHandler = new ErrorHandler() {
        @Override
        public Throwable handleError(RetrofitError cause) {
            return cause;
        }
    };

    @Override
    public void onCreate() {
        super.onCreate();
        builder = (builder != null) ? builder : createRestAdapter();
        restAdapter = builder.build();
    }

    @Override
    public CacheManager createCacheManager(Application application) throws CacheCreationException {
        CacheManager cacheManager = new CacheManager();
        cacheManager.addPersister(new RetrofitObjectPersisterFactory(application, converter));

        return cacheManager;
    }

    @Override
    public Notification createDefaultNotification() {
        // Giving null so that the service does not start in the foreground.
        return null;
    }

    @SuppressWarnings("unchecked")
    @Override
    public void addRequest(CachedSpiceRequest<?> request, Set<RequestListener<?>> listRequestListener) {
        if (request.getSpiceRequest() instanceof RetrofitSpiceRequest) {
            RetrofitSpiceRequest retrofitSpiceRequest
                    = (RetrofitSpiceRequest) request.getSpiceRequest();
            retrofitSpiceRequest.setService
                    (getRetofitService(retrofitSpiceRequest.getRetrofitedInterfaceClass()));
        }
        super.addRequest(request, listRequestListener);
    }

    /**
     * A function that is used to get the server URL.
     *
     * @return A string that contains the URL.
     */
    protected String getServerURL() {
        return PopularMoviesUtils.baseUrl();
    }

    /**
     * This is the function that is used to create the RestAdapterBuilder.
     *
     * @return An object of the RestAdapter.Builder.
     */
    private RestAdapter.Builder createRestAdapter() {
        builder = new RestAdapter.Builder();
        builder.setEndpoint(getServerURL());

        if (converter != null) {
            builder.setConverter(converter);
        } else {
            Gson customGSONWithExclude = new GsonBuilder().setExclusionStrategies(new ExclusionStrategy() {
                @Override
                public boolean shouldSkipField(FieldAttributes f) {
                    // If we want some fields to be excluded the we need to add it here.
                    // f.getDeclaredClass().equals("Your class name".class);
                    return false;
                }

                @Override
                public boolean shouldSkipClass(Class<?> clazz) {
                    return false;
                }
            }).create();
            converter = new GsonConverter(customGSONWithExclude);
            builder.setConverter(converter);
        }

        if (requestInterceptor != null) {
            builder.setRequestInterceptor(requestInterceptor);
            builder.setErrorHandler(errorHandler);
        }

        if (PopularMoviesUtils.DEBUGGABLE) {
            builder.setLogLevel(RestAdapter.LogLevel.FULL);
        } else {
            builder.setLogLevel(RestAdapter.LogLevel.NONE);
        }

        Client client = new OkClient();
        builder.setClient(client);

        return builder;
    }

    /**
     * This is the function that is used to add a request manager for a particular service.
     *
     * @param requestManager A request manager object, who's calls will be taken care of by the
     *                       service that calls this function.
     */
    protected void addRequestManger(Class<?> requestManager) {
        requestManagerList.add(requestManager);
    }

    /**
     * This is the function that is used to get the service class that is related to the request
     * manager.
     *
     * @param requestManager A request manager class who's service is required.
     * @param <T>            Not exactly provided. Not sure.
     * @return An object that represents the service that is related to the request manager.
     */
    @SuppressWarnings({"rawtypes", "unchecked"})
    protected <T> T getRetofitService(Class<T> requestManager) {
        T service = (T) requestManagerToServiceMap.get(requestManager);

        if (service == null) {
            // Creating a service for the request manager.
            service = restAdapter.create(requestManager);
            requestManagerToServiceMap.put(requestManager, service);
        }

        return service;
    }
}

