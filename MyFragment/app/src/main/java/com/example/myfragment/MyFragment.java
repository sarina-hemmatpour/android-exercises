package com.example.myfragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class MyFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //View fragmentView=LayoutInflater.from(getContext()).inflate(R.layout.fragment_my_fragment , container , false);
        //or:
        View fragmentView=inflater.inflate(R.layout.fragment_my_fragment , container , false);
        return fragmentView;
    }
}
