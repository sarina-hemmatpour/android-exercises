package com.example.littlegamenavigationcomponentexcercise;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.Objects;


public class MatchFragment extends Fragment {
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Button btnStart=view.findViewById(R.id.btnStart);
        btnStart.setOnClickListener(v->{
            Navigation.findNavController(view).navigate(R.id.action_matchFragment_to_inGameFragment);
        });
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_match, container, false);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onStart() {
        super.onStart();
        UserManager userManager=new UserManager(Objects.requireNonNull(getContext()));
        String name=userManager.getUserInfo();
        if (name.equals("")){
            //go to splash screen
            Navigation.findNavController(Objects.requireNonNull(getView())).navigate(R.id.action_matchFragment_to_auth_navigation);
        }
        else {
            TextView tvMatch= Objects.requireNonNull(getView()).findViewById(R.id.tvMatch);
            tvMatch.setText("Match\n"+name);
        }
    }
}