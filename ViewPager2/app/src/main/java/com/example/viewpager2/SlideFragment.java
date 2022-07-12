package com.example.viewpager2;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class SlideFragment extends Fragment {
    //It needs an adaptor *

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_slide , container ,false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        TextView tvData=getView().findViewById(R.id.tvData);
        tvData.setText(getArguments().getString("data").trim());

    }

    public static SlideFragment newInstance(String data) {

        Bundle args = new Bundle();
        args.putString("data" , data);
        SlideFragment fragment = new SlideFragment();
        fragment.setArguments(args);
        return fragment;
    }
}
