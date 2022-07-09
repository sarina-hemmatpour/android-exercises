package com.example.dialogfragment;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EdgeEffect;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements MyDialog.MyDialogEventListener {

    private TextView tvData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvData=findViewById(R.id.tvData);

        Button btnShow=findViewById(R.id.btnDialog);
        btnShow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //* For Dialog *
//                MyDialog myDialog=MyDialog.newInstance(tvData.getText().toString().trim());
//                myDialog.setCancelable(false);
//                myDialog.show(getSupportFragmentManager(),null);

                //For Bottom Sheet Dialog * just the same
                 MyBottomSheetDialog myBottomSheetDialog=MyBottomSheetDialog.newInstance(tvData.getText().toString().trim());
                 myBottomSheetDialog.setCancelable(false);
                 myBottomSheetDialog.show(getSupportFragmentManager() , null);


            }
        });

    }

    @Override
    public void onOkButtonClicked(String data) {

        tvData.setText(data);
    }

    @Override
    public void onCancelButtonClicked(String data) {
        Toast.makeText(this, "cancel button clicked", Toast.LENGTH_SHORT).show();
    }
}