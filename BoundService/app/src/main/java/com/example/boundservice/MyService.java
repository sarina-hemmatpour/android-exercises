package com.example.boundservice;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;

public class MyService extends Service {
    public MyService() {
    }

    private IBinder myBinder=new MyBinder();

    //vaghti activity service ro start mikone in method call mishe
    //interface e IBinder ertebat service va component ro bargharar mikone
    @Override
    public IBinder onBind(Intent intent) {
        return myBinder;
    }

    //Binder implements IBinder
    public class MyBinder extends Binder{
        //feghat bayad ye method bezarim ke inservicemun ro bargardune

        public MyService getService(){
            return MyService.this;
        }

    }

    public String getStartMassage(){
        return "MyService started!";
    }
    public String getShowMassage(){
        return "MyService is running!";
    }

    public String getStopMassage(){
        return "MyService stopped!";
    }


}