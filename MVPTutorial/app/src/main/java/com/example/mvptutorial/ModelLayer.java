package com.example.mvptutorial;


import java.util.ArrayList;

//MODEL layer
public class ModelLayer {

    public static ArrayList<User> getUsers(){
        ArrayList<User> users=new ArrayList<>(0);
        users.add(new User("Sarina","Hemmati"));
        users.add(new User("AMin","Pew"));
        users.add(new User("Shiba","Atabak"));
        users.add(new User("Sara","Brown"));
        users.add(new User("John","Amberson"));

        return users;
    }
}
