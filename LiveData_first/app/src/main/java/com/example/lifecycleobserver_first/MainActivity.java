package com.example.lifecycleobserver_first;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.util.Log;


public class MainActivity extends AppCompatActivity {


    private static final String TAG = "MainActivity";
    MyLocationListener myLocationListener;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //2: old solution
        //then we have to use savedInstanceState param to restore the value


        //NEW solution
        //myLocationListener=new MyLocationListener();
        myLocationListener=new ViewModelProvider(this).get(MyLocationListener.class);

        //it shows null for the first time
        //when we rotate the screen, Configuration *** happens so the activity restarts and its gonna show null again
        //It is wrong so we gotta fix it
        Log.i("InitialValueMainActivity", "Initial Value: " + myLocationListener.getLocation().getValue());

        //its better to observe liveData in onCreate() method
        myLocationListener.getLocation().observe(this, s->{
            Log.i(TAG, "onCreate: " + s);
        });

    }


    //1: old Solution
    // it saves the value when configuration *
    /*
    @Override
    public void onSaveInstanceState(@NonNull Bundle outState, @NonNull PersistableBundle outPersistentState) {
        outState.putString("location" , myLocationListener.getLocation().getValue());
        super.onSaveInstanceState(outState, outPersistentState);
    }
     */
}