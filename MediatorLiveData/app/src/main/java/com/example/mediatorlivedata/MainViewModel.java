package com.example.mediatorlivedata;

import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;

import java.util.Timer;
import java.util.TimerTask;

public class MainViewModel extends ViewModel {

    //MediatorLiveData: merge multiple liveData sources

    private MutableLiveData<String> source1=new MutableLiveData<>();
    private MutableLiveData<String> source2=new MutableLiveData<>();
    private MediatorLiveData<String> mainSource=new MediatorLiveData<>();

    public MainViewModel() {
        Timer timer1=new Timer();
        timer1.schedule(new TimerTask() {
            @Override
            public void run() {
                source1.postValue("source 1");
            }
        } , 1000 , 1000);

        Timer timer2=new Timer();
        timer2.schedule(new TimerTask() {
            @Override
            public void run() {
                source2.postValue("source 2");
            }
        } , 1000 , 3000);

        mainSource.addSource(source1, new Observer<String>() {
            @Override
            public void onChanged(String s) {
                mainSource.setValue(s="from "+s);
            }
        });

        mainSource.addSource(source2 , s-> mainSource.setValue("from "+s));
    }

    public MediatorLiveData<String> getMainSource() {
        return mainSource;
    }
}
