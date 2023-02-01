package com.example.mvptutorial;

import java.util.ArrayList;

public interface MainContract {
    interface Presenter{
        void onAttach(MainContract.View view);
        void onDetach();
    }
    interface View{
        void showUsers(ArrayList<User> users);
    }
}
