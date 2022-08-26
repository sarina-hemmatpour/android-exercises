package com.example.sharedpreferences;

import android.content.Context;
import android.content.SharedPreferences;

public class UserManager {

    private SharedPreferences sharedPreferences;

    public UserManager(Context context)
    {
        sharedPreferences=context.getSharedPreferences("user_info" , Context.MODE_PRIVATE);

        //listener
        sharedPreferences.registerOnSharedPreferenceChangeListener(new SharedPreferences.OnSharedPreferenceChangeListener() {
            @Override
            public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String s) {
                //todo
            }
        });

        //to remove listener:
        //sharedPreferences.unregisterOnSharedPreferenceChangeListener();
    }

    public void saveInfo(String fullName , String email , boolean gender)
    {
        SharedPreferences.Editor editor=sharedPreferences.edit();
        editor.putString("fullName" , fullName);
        editor.putString("email" , email);
        editor.putBoolean("gender" , gender);
        editor.apply(); // on a new thread
//        editor.commit(); // on the UI thread (not suggested)
    }

    public String getFullName()
    {
        return sharedPreferences.getString("fullName" , "");
    }
    public String getEmail()
    {
        return sharedPreferences.getString("email" , "");
    }
    public boolean getGender()
    {
        return sharedPreferences.getBoolean("gender" , false);
    }

    public void clearInfo()
    {
        SharedPreferences.Editor editor=sharedPreferences.edit();
        editor.clear();
        editor.apply();
    }

    public void clearFullName()
    {
        SharedPreferences.Editor editor=sharedPreferences.edit();
        editor.remove("fullName");
        editor.apply();
    }
}
