package com.example.lifecycleobserver_first;

import androidx.lifecycle.DefaultLifecycleObserver;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LifecycleOwner;

import java.sql.Time;
import java.util.Timer;
import java.util.TimerTask;

public class MyLocationListener implements DefaultLifecycleObserver {

    private Timer timer;
    private CallBack callBack;

    public MyLocationListener(CallBack callBack , Lifecycle lifecycle) {
        this.callBack = callBack;

        if (lifecycle.getCurrentState().isAtLeast(Lifecycle.State.STARTED)){
            // TODO: 5/5/2023
        }
    }

    @Override
    public void onStart(LifecycleOwner owner){
        timer=new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                callBack.onUpdate("Location: "+ System.currentTimeMillis());
            }
        } , 0 , 1000);
    }


    @Override
    public void onStop(LifecycleOwner owner){
        if (timer!=null){
            timer.cancel();
            timer.purge();
            timer=null;
        }
    }

    interface CallBack{
        void onUpdate(String location);
    }

}
