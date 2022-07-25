package com.example.actionbar;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        ActionBar actionBar=getSupportActionBar();
        actionBar.setIcon(R.mipmap.chrome_foreground);
        actionBar.setTitle("Second Activity");
        actionBar.setDisplayShowHomeEnabled(true);
        actionBar.setDisplayUseLogoEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(true); //adds a back button into the action bar
        /* in order to perform u need to go to the manifest file and add these lines
        in the main2Activity par =>
        <meta-data android:name="android.support.PARENT_ACTIVITY"
                android:value=".MainActivity"/>
         */
    }
}