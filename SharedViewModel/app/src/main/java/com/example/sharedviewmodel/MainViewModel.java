package com.example.sharedviewmodel;

import androidx.lifecycle.ViewModel;

public class MainViewModel extends ViewModel {
    private User user=new User();

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
