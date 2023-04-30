package com.example.littlegamenavigationcomponentexcercise;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


public class InGameFragment extends Fragment {

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Button btnCorrect=view.findViewById(R.id.btnCorrect);
        btnCorrect.setOnClickListener(v->{
            Navigation.findNavController(v).navigate(R.id.action_inGameFragment_to_winnerFragment);
        });

        Button btnIncorrect=view.findViewById(R.id.btnIncorrect);
        btnIncorrect.setOnClickListener(v->{
            Navigation.findNavController(v).navigate(R.id.action_inGameFragment_to_gameOverFragment);
        });
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_in_game, container, false);
    }
}