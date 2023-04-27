package com.example.eventbus;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //EventBus.getDefault().register(this);


        Button btnActivityB=findViewById(R.id.btnActivityB);
        btnActivityB.setOnClickListener(view -> {
          startActivity(new Intent(MainActivity.this , ActivityB.class));
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        EventBus.getDefault().register(this);
    }

    @Override
    protected void onStop() {
        super.onStop();
        EventBus.getDefault().unregister(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
       // EventBus.getDefault().unregister(this);
    }

    //to clarify on which event we have subscribed
    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMyEvent(MyEvent myEvent){
        Toast.makeText(this, myEvent.eventMessage, Toast.LENGTH_SHORT).show();

    }

}