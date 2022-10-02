package com.example.notificationtutorial;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

import android.annotation.SuppressLint;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;

import java.util.Random;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public void onClick(View view) {
        NotificationManager manager= (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        switch (view.getId()){
            case R.id.btn_main_simpleNotification:
                Intent intent=new Intent(this , MainActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK|Intent.FLAG_ACTIVITY_NEW_TASK);
                PendingIntent pendingIntent=PendingIntent.getActivity(this , 0 , intent , 0);

                Notification simpleNotification=new NotificationCompat.Builder(this , App.NOTIFICATION_CHANNEL_ID)
                        .setSmallIcon(android.R.drawable.stat_notify_chat)
                        .setLargeIcon(BitmapFactory.decodeResource(getResources() , R.drawable.profile))
                        .setContentTitle("New Notification")
                        .setContentText("Hello, This is my first notification!!!")
                        .setShowWhen(true)
                        .setContentIntent(pendingIntent)
                        .build();

                manager.notify(new Random().nextInt(), simpleNotification);
                break;

            case R.id.btn_main_bigPictureStyleNotification:
                Intent intent1=new Intent(this , MainActivity.class);
                intent1.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK|Intent.FLAG_ACTIVITY_NEW_TASK);
                PendingIntent pendingIntent1=PendingIntent.getActivity(this , 1 , intent1 , 0);

                Notification bigPictureNotification=new NotificationCompat.Builder(this , App.NOTIFICATION_CHANNEL_ID)
                        .setSmallIcon(android.R.drawable.stat_notify_chat)
                        .setShowWhen(true)
                        .setLargeIcon(BitmapFactory.decodeResource(getResources() , R.mipmap.ic_launcher))
                        .setContentIntent(pendingIntent1)
                        .setContentTitle("New Notification")
                        .setContentText("Hello, This is my first notification!!!")
                        .setStyle(new NotificationCompat.BigPictureStyle().bigPicture(
                                BitmapFactory.decodeResource(getResources() , R.drawable.banner)
                        ).setBigContentTitle("Big Picture Style Title").bigLargeIcon(BitmapFactory.decodeResource(getResources() , R.drawable.profile)))
                        .build();
                manager.notify(new Random().nextInt() , bigPictureNotification);

                break;

            case R.id.btn_main_bigTextStyleNotification:
                Intent intent2=new Intent(this , MainActivity.class);
                intent2.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK|Intent.FLAG_ACTIVITY_NEW_TASK);
                PendingIntent pendingIntent2=PendingIntent.getActivity(this , 2 , intent2 , 0);

                Notification bigTextNotification=new NotificationCompat.Builder(this , App.NOTIFICATION_CHANNEL_ID)
                        .setSmallIcon(android.R.drawable.stat_notify_chat)
                        .setShowWhen(true)
                        .setContentIntent(pendingIntent2)
                        .setLargeIcon(BitmapFactory.decodeResource(getResources() , R.mipmap.ic_launcher))
                        .setContentTitle("New Notification")
                        .setContentText("Hello, This is my first notification!!!")
                        .setStyle(new NotificationCompat.BigTextStyle().bigText("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!Hello, This is my first notification!!!Hello, This is my first notification!!!Hello, This is my first notification!!!Hello, This is my first notification!!!Hello, This is my first notification!!!Hello, This is my first notification!!!Hello, This is my first notification!!!Hello, This is my first notification!!!"))
                        .build();
                manager.notify(new Random().nextInt() , bigTextNotification);
                break;

            case R.id.btn_main_inboxStyleNotification:
                //showing a text in multiple lines
                Intent intent3=new Intent(this , MainActivity.class);
                intent3.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                PendingIntent pendingIntent3=PendingIntent.getActivity(this , 3 , intent3 , 0);

                Notification inboxStyleNotification =new NotificationCompat.Builder(this , App.NOTIFICATION_CHANNEL_ID)
                        .setSmallIcon(android.R.drawable.stat_notify_chat)
                        .setShowWhen(true)
                        .setContentIntent(pendingIntent3)
                        .setLargeIcon(BitmapFactory.decodeResource(getResources() , R.mipmap.ic_launcher))
                        .setContentTitle("New Notification")
                        .setStyle(new NotificationCompat.InboxStyle().addLine("Hello, This is my first notification!!!")
                        .addLine("Hello, This is my second notification!!!")
                        .addLine("Hello, This is my third notification!!!"))
                        .build();

                manager.notify(new Random().nextInt() , inboxStyleNotification);
                break;

        }
    }
}