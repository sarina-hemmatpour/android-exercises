package com.example.studentlistmvvm;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainViewModelFactory implements ViewModelProvider.Factory {

    ApiService apiService;
    public MainViewModelFactory() {
        Retrofit retrofit=new Retrofit.Builder()
                .baseUrl("http://192.168.56.1/php/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        apiService=retrofit.create(ApiService.class);
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        return (T) new MainViewModel(apiService);
    }
}
