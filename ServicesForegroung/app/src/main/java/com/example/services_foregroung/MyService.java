package com.example.services_foregroung;

import android.app.AppComponentFactory;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

import androidx.core.app.NotificationCompat;

public class MyService extends Service {
    public MyService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public void onCreate() {
        super.onCreate();
    }

    @Override
    public void onDestroy() {

        stopForeground(true);
        super.onDestroy();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        startForeground(1001 , generateNotification());

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        stopSelf();

        return START_NOT_STICKY;
    }

    private static final String CHANNEL_ID="app_default";

    private Notification generateNotification(){

        NotificationManager notificationManager=
                (NotificationManager) getSystemService(NOTIFICATION_SERVICE);

        if (notificationManager==null)
            return null;


        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
            NotificationChannel notificationChannel=new NotificationChannel(CHANNEL_ID ,
                    "Default" , NotificationManager.IMPORTANCE_HIGH);

            notificationManager.createNotificationChannel(notificationChannel);
        }

        Notification notification=new NotificationCompat.Builder(this, CHANNEL_ID)
                .setSmallIcon(android.R.drawable.stat_notify_chat)
                .setContentTitle("Foreground Service")
                .setContentText("A foreground service is running ...")
                .build();


        return notification;

    }
}