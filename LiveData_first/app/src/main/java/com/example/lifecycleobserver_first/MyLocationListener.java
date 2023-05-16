package com.example.lifecycleobserver_first;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import java.util.Timer;
import java.util.TimerTask;

public class MyLocationListener {

    private Timer timer;

    private MutableLiveData<String> location=new MutableLiveData<>();
    public MyLocationListener() {
        timer=new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                //setValue()
                //but this is another thread so we gotta use postValue()
                location.postValue("Location: "+ System.currentTimeMillis());
            }
        } , 0 , 1000);
    }


    public LiveData<String> getLocation() {
        return location;
    }
}
