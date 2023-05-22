package com.example.studentlistmvvm;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainViewModel extends ViewModel {
    private ApiService apiService;
    private MutableLiveData<List<Student>> studentsLiveData=new MutableLiveData<>();
    private MutableLiveData<String> errorMessageLiveData=new MutableLiveData<>();

    public MainViewModel(ApiService apiService){
        this.apiService=apiService;
        apiService.getAll().enqueue(new Callback<List<Student>>() {
            @Override
            public void onResponse(Call<List<Student>> call, Response<List<Student>> response) {
                studentsLiveData.setValue(response.body());
            }

            @Override
            public void onFailure(Call<List<Student>> call, Throwable t) {
                errorMessageLiveData.setValue(t.getMessage());
            }
        });
    }

    public LiveData<List<Student>> getStudentsLiveData() {
        return studentsLiveData;
    }

    public LiveData<String> getErrorMessageLiveData() {
        return errorMessageLiveData;
    }
}
