package com.example.littlegamenavigationcomponentexcercise;

import android.content.Context;
import android.content.SharedPreferences;

public class UserManager {
    private SharedPreferences sharedPreferences;

    public UserManager(Context context) {
        this.sharedPreferences=context.getSharedPreferences("auth" , Context.MODE_PRIVATE);
    }

    public void saveUserInfo(String name){
        sharedPreferences.edit()
                .putString("name" , name)
                .apply();
    }

    public String getUserInfo(){
        return sharedPreferences.getString("name" , "");
    }
}
