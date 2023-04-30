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

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link TitleScreenFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class TitleScreenFragment extends Fragment {

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        Button btnPlay=view.findViewById(R.id.btnPlay);
        btnPlay.setOnClickListener(v->{
            Navigation.findNavController(v).navigate(R.id.action_titleScreenFragment_to_registerFragment);
        });
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_title_screen, container, false);
    }
}