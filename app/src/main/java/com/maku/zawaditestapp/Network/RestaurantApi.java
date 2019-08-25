package com.maku.zawaditestapp.Network;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RestaurantApi {

    // Trailing slash is needed in the base url
    public static final String BASE_URL = "https://sleepy-garden-51801.herokuapp.com/";
    Retrofit retrofit = new Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build();

}
