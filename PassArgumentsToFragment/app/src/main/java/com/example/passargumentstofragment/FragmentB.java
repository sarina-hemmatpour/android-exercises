package com.example.passargumentstofragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;


public class FragmentB extends Fragment {

    public static final String EXTRA_KEY_DATA = "127";


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_b , container , false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        TextView textView=getView().findViewById(R.id.tvData_b);

        textView.setText(getArguments().getString(EXTRA_KEY_DATA).trim());

    }


    public static FragmentB newInstance(String data) {

        Bundle args = new Bundle();
        args.putString(EXTRA_KEY_DATA,data);
        FragmentB fragment = new FragmentB();
        fragment.setArguments(args);
        return fragment;
    }
}
