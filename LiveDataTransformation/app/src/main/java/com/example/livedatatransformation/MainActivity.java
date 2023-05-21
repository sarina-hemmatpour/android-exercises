package com.example.livedatatransformation;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.content.pm.VersionedPackage;
import android.os.Bundle;
import android.util.Log;

import java.security.Provider;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        MainViewModel mainViewModel= new ViewModelProvider(this ).get(MainViewModel.class);
        mainViewModel.getFullNameLiveData().observe(this, fullName ->{
            Log.i(TAG, "onCreate: " + fullName);
        });

    }
}