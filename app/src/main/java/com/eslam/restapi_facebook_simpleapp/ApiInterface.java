package com.eslam.restapi_facebook_simpleapp;

import java.util.HashMap;
import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

interface ApiInterface {
    @GET("posts")
    Call<List<Post>> getPost(@Query("userId") String userId);

    // public Call<Post> getPost();

    @POST("posts")
    //to sent with hash map for multiple vars
    Call<Post> storePost(@Body HashMap<Object, Object> map);

    //to sent post with class we already have
    //public Call<Post> storePost(@Body Post post);
}
