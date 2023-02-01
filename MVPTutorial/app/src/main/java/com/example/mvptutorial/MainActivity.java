package com.example.mvptutorial;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;


//VIEW layer
public class MainActivity extends AppCompatActivity implements MainContract.View{

    PresenterLayer presenterLayer=new PresenterLayer();

    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        presenterLayer.onAttach(this);
    }

    @Override
    public void showUsers(ArrayList<User> users){
        Log.i(TAG, "showUsers: " + users.toString());
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenterLayer.onDetach();
    }
}