package com.example.studentlistmvvm;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiService {

    @GET("index.php/")
    Call<List<Student>> getAll();
}
