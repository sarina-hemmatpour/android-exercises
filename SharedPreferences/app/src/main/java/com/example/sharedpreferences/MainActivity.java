package com.example.sharedpreferences;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        UserManager userManager = new UserManager(this);

        TextInputEditText etFullName=findViewById(R.id.et_main_fullName) ;
        TextInputEditText etEmail=findViewById(R.id.et_main_email);
        RadioButton rbMale=findViewById(R.id.radioBtn_main_male);
        RadioButton rbFemale=findViewById(R.id.radioBtn_main_female);
        MaterialButton btnSave=findViewById(R.id.btn_main_save);
        MaterialButton btnClear=findViewById(R.id.btn_main_clear);
        RadioGroup radioGroup=findViewById(R.id.radioGp_main);


        //loading
        etFullName.setText(userManager.getFullName());
        etEmail.setText(userManager.getEmail());
        if (userManager.getGender())
        {
            rbMale.setChecked(true);
        }
        else {
            rbFemale.setChecked(true);
        }

        btnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                etEmail.setText("");
                etFullName.setText("");
                rbFemale.setChecked(true);
                userManager.clearInfo();
                Toast.makeText(MainActivity.this, "اطلاعات پاک شدند!", Toast.LENGTH_SHORT).show();
            }
        });


        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (etFullName.length()>0 && etEmail.length()>0)
                {
                    userManager.saveInfo(etFullName.getText().toString().trim() ,
                            etEmail.getText().toString().trim()
                    ,rbMale.isChecked());

                    Toast.makeText(MainActivity.this, "اطلاعات با موفقیت دخیره شدند!", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Toast.makeText(MainActivity.this, "اطلاعات خود را کامل کنید.", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}