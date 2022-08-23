package com.example.firstsharedpreferences;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    TextView tvWelcome;
    EditText etName;
    Button btnSubmit;

    private static final String MY_PREFERENCES_FILE_NAME="com.example.firstsharedpreferences.Names";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvWelcome=findViewById(R.id.tv_main_welcome);
        etName=findViewById(R.id.et_main_name);
        btnSubmit=findViewById(R.id.btn_main_submit);


        //checking shared preferences
        SharedPreferences prefs=getSharedPreferences(MY_PREFERENCES_FILE_NAME , MODE_PRIVATE);
        String userName=prefs.getString("name" , "").trim();
        if (userName.length()>0)
        {
            tvWelcome.setText("Welcome to my app, "+userName +"!");
        }
        else
        {
            tvWelcome.setText("Hi! What is your name?");
        }

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (etName.length()>0)
                {
                    String name=etName.getText().toString().trim();
                    tvWelcome.setText("Welcome to my app, "+name +"!");

                    SharedPreferences.Editor editor=getSharedPreferences(MY_PREFERENCES_FILE_NAME , MODE_PRIVATE).edit();
                    editor.putString("name" , name);
                    editor.commit();
                }
            }
        });

    }
}