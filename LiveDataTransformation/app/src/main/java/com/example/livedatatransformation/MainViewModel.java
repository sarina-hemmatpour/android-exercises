package com.example.livedatatransformation;

import androidx.arch.core.util.Function;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Transformations;
import androidx.lifecycle.ViewModel;

public class MainViewModel extends ViewModel {
    private MutableLiveData<User> userLiveData;
    private LiveData<String> fullNameLiveData;

    public MainViewModel(){
        userLiveData=new MutableLiveData<>();
        fullNameLiveData= Transformations.map(userLiveData,
                userLiveData -> userLiveData.getFirstname()+" "+userLiveData.getLastname());

        userLiveData.setValue(new User("Sarina" , "Hemmatpour"));

    }

    public LiveData<String> getFullNameLiveData() {
        return fullNameLiveData;
    }
}
