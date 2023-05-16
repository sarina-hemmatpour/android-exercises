package com.example.lifecycleobserver_first;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;


public class MainActivity extends AppCompatActivity {


    private static final String TAG = "MainActivity";
    MyLocationListener myLocationListener;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        myLocationListener=new MyLocationListener();

        //its better to observe liveData in onCreate() method
        myLocationListener.getLocation().observe(this, s->{
            Log.i(TAG, "onCreate: " + s);
        });

    }

}