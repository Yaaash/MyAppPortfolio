package com.udacity.yashika.myappportfolio.popular_movies.model;

import com.google.gson.annotations.SerializedName;

/**
 * @author yashika.
 */
public class MovieRequestBody {

    @SerializedName("api_key")
    private String apiKey;

    public String getApiKey() {
        return apiKey;
    }

    public void setApiKey(String apiKey) {
        this.apiKey = apiKey;
    }
}
