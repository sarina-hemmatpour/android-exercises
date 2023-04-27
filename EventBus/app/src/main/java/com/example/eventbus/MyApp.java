package com.example.eventbus;

import android.app.Application;

import org.greenrobot.eventbus.EventBus;

import java.util.Timer;
import java.util.TimerTask;

public class MyApp extends Application {

    Timer timer=new Timer();
    int counter=0;
    @Override
    public void onCreate() {
        super.onCreate();

        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                MyEvent event=new MyEvent();
                event.eventMessage+=counter;
                EventBus.getDefault().post(event);
                counter++;
            }
        }, 3000, 3000);

    }
}
