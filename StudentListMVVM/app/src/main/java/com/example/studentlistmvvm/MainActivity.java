package com.example.studentlistmvvm;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.database.Observable;
import android.os.Bundle;
import android.util.Log;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MainViewModel mainViewModel=new ViewModelProvider(this , new MainViewModelFactory()).get(MainViewModel.class);
        mainViewModel.getStudentsLiveData().observe(this, students -> {
            Log.i("MainActivity", "onCreate: "+students.toString());
        });
        mainViewModel.getErrorMessageLiveData().observe(this , error ->{
            Log.i("MainActivity", "onCreate: "+error);

        });


    }
}