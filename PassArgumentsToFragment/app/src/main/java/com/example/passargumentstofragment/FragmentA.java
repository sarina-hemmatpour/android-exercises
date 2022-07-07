package com.example.passargumentstofragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

public class FragmentA  extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_a , container , false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        Button btnDone=view.findViewById(R.id.btnDone_a);
        btnDone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                EditText etData=getView().findViewById(R.id.etData_a);
                String string=etData.getText().toString();

//                Fragment fragmentB=new FragmentB();
//                Bundle bundle=new Bundle();
//                bundle.putString(FragmentB.EXTRA_KEY_DATA, string);
//                fragmentB.setArguments(bundle);

                FragmentTransaction fragmentTransaction = getParentFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.mainContainer , FragmentB.newInstance(string));
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();


            }
        });



    }
}
