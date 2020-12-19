package com.eslam.restapi_facebook_simpleapp;

import retrofit2.Call;
import retrofit2.http.GET;

interface ApiInterface {
    @GET("posts/2")
    public Call<Post> getPost();
}
