package com.example.mvptutorial;


//PRESENTATION layer
public class PresenterLayer implements MainContract.Presenter {

    private MainContract.View view;


    @Override
    public void onAttach(MainContract.View view) {
        this.view=view;
        if (this.view!=null){
            view.showUsers(ModelLayer.getUsers());
        }

    }

    @Override
    public void onDetach(){
        view=null;
    }
}
