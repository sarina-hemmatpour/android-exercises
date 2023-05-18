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


public class StepOneFragment extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_step_one, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        MainViewModel mainViewModel=new ViewModelProvider(requireActivity()).get(MainViewModel.class);

        EditText etName=view.findViewById(R.id.et_step1Frag_name);
        EditText etLastname=view.findViewById(R.id.et_step1Frag_lastname);

        etName.setText(mainViewModel.getUser().getFirstname());
        etLastname.setText(mainViewModel.getUser().getLastname());

        ((Button)view.findViewById(R.id.btn_step1Frag_next)).setOnClickListener(v->{
            if (etName.length()>0 && etLastname.length()>0){
                //save user info
                mainViewModel.getUser().setFirstname(etName.getText().toString().trim());
                mainViewModel.getUser().setLastname(etLastname.getText().toString().trim());
                //start step2frag
                Navigation.findNavController(v).navigate(R.id.action_stepOneFragment_to_stepTwoFragment);
            }
            else {
                Toast.makeText(getActivity(), "Fill the fields", Toast.LENGTH_SHORT).show();
            }
        });
    }
}