package com.example.sharedviewmodel;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //The instance of ViewModel should be created here
        MainViewModel mainViewModel=new ViewModelProvider(this).get(MainViewModel.class);
    }
}