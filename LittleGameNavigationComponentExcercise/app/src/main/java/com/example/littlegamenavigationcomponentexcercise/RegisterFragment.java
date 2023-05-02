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
import android.widget.EditText;
import android.widget.Toast;

import java.util.Objects;


public class RegisterFragment extends Fragment {

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        EditText etName=view.findViewById(R.id.etName);


        Button btnRegister=view.findViewById(R.id.btnRegister);
        btnRegister.setOnClickListener(v->{
            if (etName.length()>0){
                UserManager userManager=new UserManager(Objects.requireNonNull(getContext()));
                userManager.saveUserInfo(etName.getText().toString());
                Navigation.findNavController(v).navigate(R.id.action_registerFragment_to_matchFragment);
            }else {
                Toast.makeText(this.getContext(), "Enter your name", Toast.LENGTH_SHORT).show();
            }

        });
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_register, container, false);
    }
}