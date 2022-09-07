package com.example.broadcastreceiver;

import androidx.appcompat.app.AppCompatActivity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.widget.TextView;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    /*
    event hayi ke tu manifest mitunim  ejra konim =>
    https://developer.android.com/guide/components/broadcast-exceptions
     */


    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView=findViewById(R.id.tv_main);

        checkInternetConnection(); // it doesn't work :((((((

        IntentFilter intentFilter=new IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION);
        intentFilter.addAction("android.net.conn.connectivity_CHANGE");

        registerReceiver(broadcastReceiver , intentFilter);
        //hatman bayad unregister beshe

    }

    private void checkInternetConnection()
    {
//        boolean flag=NetworkUtil.checkNetworkState(this); // it doesn't work :((((((

        boolean flag=isNetworkConnected();

        if (flag)
        {
            textView.setText("Connected to the network");
        }else{
            textView.setText("No internet connection");
        }
    }

    public static boolean isNetworkConnected() {
        Runtime runtime = Runtime.getRuntime();
        try {
            Process ipProcess = runtime.exec("/system/bin/ping -c 1 8.8.8.8");
            int     exitValue = ipProcess.waitFor();
            return (exitValue == 0);
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }

        return false;
    }
    
    //agar bekhaym vaqti be net motasel shod motevaje beshim bayad be event e etesal be net goosh bedim =>

    private BroadcastReceiver broadcastReceiver= new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            //it runs on main thread
            checkInternetConnection();
        }
    };

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(broadcastReceiver);
    }
}