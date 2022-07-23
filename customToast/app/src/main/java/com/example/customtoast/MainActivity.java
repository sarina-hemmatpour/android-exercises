package com.example.customtoast;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button btnToast;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnToast=findViewById(R.id.btnToast);
        btnToast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, R.string.toast_massage, Toast.LENGTH_SHORT).show();
                showCustomToast(getResources().getString(R.string.toast_massage));
            }
        });

    }


    public void showCustomToast(String massage)
    {
        View view= LayoutInflater.from(this).inflate(R.layout.item_custom_toast , (ViewGroup) findViewById(R.id.toastContainer) , false);

        TextView tvMassage=view.findViewById(R.id.tvToast);
        tvMassage.setText(massage);

        Toast toast=new Toast(MainActivity.this);
        toast.setView(view);
        toast.setDuration(Toast.LENGTH_LONG);
        toast.setGravity(Gravity.BOTTOM|Gravity.FILL_HORIZONTAL , 0 , 0);
        toast.show();
    }

}