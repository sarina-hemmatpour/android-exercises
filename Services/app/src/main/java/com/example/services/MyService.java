package com.example.services;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;
import android.widget.Toast;

public class MyService extends Service {

    /*
    add this to manifest => <service android:name=".MyService"/>
     */

    private static final String TAG = "MyService";
    public MyService() {
        Log.i(TAG, "MyService: ");
    }

    @Override
    public void onCreate() {
        Log.i(TAG, "onCreate: ");
        super.onCreate();

    }

    @Override
    public void onDestroy() {
        Log.i(TAG, "onDestroy: ");
        super.onDestroy();

    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        Toast.makeText(this, "alrkjsf", Toast.LENGTH_SHORT).show();
        Log.i(TAG, "onStartCommand: ");
        // todo
        stopSelf();     //services continue to do their job until tou destroy them


        //return super.onStartCommand(intent, flags, startId);
        //return START_STICKY; //the service runs all the time; the next intent will be null

        return START_NOT_STICKY; //if the service gets killed it wont start running again

        //return START_REDELIVER_INTENT; //The service restarts but the intent won't be null
    }

    @Override
    public IBinder onBind(Intent intent) {

        Log.i(TAG, "onBind: ");

        return null;
        //if your service is not Bound you have to remove the lines below
        // TODO: Return the communication channel to the service.
        //throw new UnsupportedOperationException("Not yet implemented");
    }

    /*
    There are 3 kinds of Services in android:

    1- Foreground: A foreground service performs some operation that is noticeable
       to the user. For example, an audio app would use a foreground service to play
       an audio track. Foreground services must display a Notification. Foreground
       services continue running even when the user isn't interacting with the app.

    2- Background: A background service performs an operation that isn't directly
       noticed by the user. For example, if an app used a service to compact its storage,
       that would usually be a background service.

    3- Bound: A bound service is the server in a client-server interface. It allows
       components (such as activities) to bind to the service, send requests,
       receive responses, and perform interprocess communication (IPC).
       => vasl mikshe be ye componente dige mesle activity
       masalan tyuye music player age ruye pause click konim tuye notification ham pause
       mishe yani un notification bound shode be un activity (tu music player az tarkibe
       bound va foreground estefade mishe); agar barname ro bebandim az halate bound dar miyad o
       mire tu halate foreground.


       *dar android vaghti mahdudiate mnbe darim, un process hayi olaviyat daran ke
       karbar ba un ha taamol dare. service ha ham UI nadaran pas az activity
       olaviyate kamtari daran.

       *beyne service ha olaviyate backgound service az hame payin tare.
       pas ehtemale kill shodanesh ham bishtare.

       *Services run on the MAIN thread!!!

     */
}