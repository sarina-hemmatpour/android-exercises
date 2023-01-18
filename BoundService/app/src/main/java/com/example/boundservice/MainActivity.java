package com.example.boundservice;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private MyService myService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent serviceIntent=new Intent(this , MyService.class);


        Button btnStartService=findViewById(R.id.btn_main_startService);
        btnStartService.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(myService==null){
                    bindService(serviceIntent , serviceConnection , BIND_AUTO_CREATE );
                    Toast.makeText(MainActivity.this, "MyService started!", Toast.LENGTH_SHORT).show();
                }
                else
                    Toast.makeText(MainActivity.this, myService.getShowMassage(), Toast.LENGTH_SHORT).show();
            }
        });

        Button btnStopService=findViewById(R.id.btn_main_stopService);
        btnStopService.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (myService!=null){
                    Toast.makeText(MainActivity.this, myService.getStopMassage(), Toast.LENGTH_SHORT).show();
                    unbindService(serviceConnection);
                    myService=null;
                }
                else{
                    Toast.makeText(MainActivity.this, "Start the service.", Toast.LENGTH_SHORT).show();
                }
            }
        });

        ((Button)findViewById(R.id.btn_main_showMassage)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (myService!=null)
                    Toast.makeText(MainActivity.this, myService.getShowMassage(), Toast.LENGTH_SHORT).show();
            }
        });


    }
    private ServiceConnection serviceConnection=new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            if (iBinder!=null)
                myService=((MyService.MyBinder)iBinder).getService();
//                massage=((MyService.MyBinder)iBinder).getService().getStartMassage();
        }

        @Override
        public void onServiceDisconnected(ComponentName componentName) {
            myService=null;
        }
    };



    @Override
    protected void onDestroy() {
        super.onDestroy();
        unbindService(serviceConnection);
    }
}