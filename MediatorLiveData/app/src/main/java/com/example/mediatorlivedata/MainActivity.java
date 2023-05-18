package com.example.mediatorlivedata;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MainViewModel mainViewModel=new ViewModelProvider(this).get(MainViewModel.class);

        mainViewModel.getMainSource().observe(this, value ->{
            Log.i(TAG, "onCreate: " + value);
        });

    }
}