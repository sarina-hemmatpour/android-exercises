package com.example.notificationtutorial;

import android.app.Application;
import android.app.NotificationChannel;
import android.app.NotificationManager;

public class App extends Application {

    /*
    add in manifest=>
    android:name=".App"
     */

    static final String NOTIFICATION_CHANNEL_ID="MyApp";

    @Override
    public void onCreate() {
        super.onCreate();

        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
            NotificationManager notificationManager= (NotificationManager) getSystemService(NOTIFICATION_SERVICE);

            NotificationChannel notificationChannel=new NotificationChannel(NOTIFICATION_CHANNEL_ID ,
                    "Default Notification Channel" , NotificationManager.IMPORTANCE_HIGH);
            notificationChannel.setDescription("Test notification channel description");
//            notificationChannel.setSound();

            if (notificationManager!=null)
            {
                notificationManager.createNotificationChannel(notificationChannel);
            }
        }

    }
}
