package com.example.sharedviewmodel;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class ResultFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_result, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        MainViewModel mainViewModel=new ViewModelProvider(requireActivity()).get(MainViewModel.class);

        TextView tvName=view.findViewById(R.id.tv_resultFrag_name);
        TextView tvLastname=view.findViewById(R.id.tv_resultFrag_lastname);
        TextView tvEmail=view.findViewById(R.id.tv_resultFrag_email);

        //show info
        tvName.setText(mainViewModel.getUser().getFirstname());
        tvLastname.setText(mainViewModel.getUser().getLastname());
        tvLastname.setText(mainViewModel.getUser().getEmail());



    }
}