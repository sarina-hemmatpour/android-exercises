package com.example.sharedviewmodel;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class StepTwoFragment extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_step_two, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        MainViewModel mainViewModel=new ViewModelProvider(requireActivity()).get(MainViewModel.class);

        EditText etEmail=view.findViewById(R.id.et_step2Frag_email);
        etEmail.setText(mainViewModel.getUser().getEmail());
        (view.findViewById(R.id.btn_step2Frag_next)).setOnClickListener(v->{
            if (etEmail.length()>0){
                //save info
                mainViewModel.getUser().setEmail(etEmail.getText().toString().trim());
                //load result frag
                Navigation.findNavController(v).navigate(R.id.action_stepTwoFragment_to_resultFragment);
            }
            else
                Toast.makeText(requireActivity(), "Fill the field", Toast.LENGTH_SHORT).show();
        });

    }
}