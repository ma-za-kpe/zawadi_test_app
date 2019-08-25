package com.maku.zawaditestapp.Intefaces;

import com.maku.zawaditestapp.POJO.Search;
import com.maku.zawaditestapp.POJO.SearchedByName;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface MyApiEndpointInterface {

//    get restaurant by name
    @GET("json/search")
    Call<Search> getByRestaurant(@Query("restaurant") String restaurant);

//get all the items in the db
    @GET("allItems")
    Call<SearchedByName> getRestaurant();

    //    register for the zawadi service
//    @POST("users/register")
//    Call<register> registerUser();

    //    login to the zawadi service
//    @POST("users/loginUser")
//    Call<login> loginUser();

    //    logout of te zawadi service

}
