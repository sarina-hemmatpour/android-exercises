package com.example.lifecycleobserver_first;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleRegistry;

import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {


    private static final String TAG = "MainActivity";
    MyLocationListener myLocationListener;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        myLocationListener=new MyLocationListener(new MyLocationListener.CallBack() {
            @Override
            public void onUpdate(String location) {
                Log.i(TAG, "onUpdate: " + location);
            }
        } , getLifecycle());

        //lifecycle Owner ke observer dare
        //fragments and AppCompatActivities implement LifeCycleOwner 
        getLifecycle().addObserver(myLocationListener);

    }

//    @Override
//    protected void onStart() {
//        super.onStart();
//        myLocationListener.onStart();
//    }
//
//    @Override
//    protected void onStop() {
//        super.onStop();
//        myLocationListener.onStop();
//    }
}