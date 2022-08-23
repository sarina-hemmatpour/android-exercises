package com.example.retrofitgetapi;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;

public interface RetrofitApiService {

    @GET("posts")
    Call<ArrayList<Post>> getPosts();
}
