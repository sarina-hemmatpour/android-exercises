package com.example.customedittextfloatinghint_autocomplete;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;

public class MainActivity extends AppCompatActivity {

    AutoCompleteTextView tvFirstname;
    AutoCompleteTextView tvLastname;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvFirstname=findViewById(R.id.etFirstname);

        String[] names={"Sarina" , "Sara" , "Soroush" , "Sabrina" , "Serin" , "Soheil" , "Somaye"};

        ArrayAdapter<String> arrayAdapter=new ArrayAdapter<String>(this ,
                android.R.layout.simple_dropdown_item_1line , names); //a premake type of layout for autocomplete

        tvFirstname.setThreshold(1); //after typing 1 char it starts to show autocomplete list
        tvFirstname.setAdapter(arrayAdapter);

        tvLastname=findViewById(R.id.etLastname);
        tvLastname.setThreshold(1);
        tvLastname.setAdapter(new ArrayAdapter<String>(this ,
                R.layout.custom_design_autocomplete , names)); //custom design for autocomplete

    }
}