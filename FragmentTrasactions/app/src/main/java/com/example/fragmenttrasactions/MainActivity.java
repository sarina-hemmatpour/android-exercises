package com.example.fragmenttrasactions;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.Objects;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /* az fragment transaction ha estefade mikonim baraye add kardane fragmen
        tuye frame i ke sakhtim*/
        // vazifeye modiriyate fragment ha bar ohdeye Fragment manager ast

        // Add Transaction
        FragmentTransaction addFragmentTransaction=getSupportFragmentManager().beginTransaction();
        addFragmentTransaction.add(R.id.frame_main_fragmentContainer , new FragmentA());
        /*in esm ke be addToBackStack dadim vaqti karbord dare ke bekhaym yek transaction ro
        az tu backStack bekeshim birun => mamulan meghdare null midim*/
        addFragmentTransaction.addToBackStack("FragmentA");
        addFragmentTransaction.commit();

        Button btnRemoveFrag=findViewById(R.id.btnRemoveFragment);
        btnRemoveFrag.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentTransaction removeFragmentTransaction=getSupportFragmentManager().beginTransaction();
                removeFragmentTransaction.remove(Objects.requireNonNull(getSupportFragmentManager().findFragmentById(R.id.frame_main_fragmentContainer)));
                removeFragmentTransaction.addToBackStack(null);
                removeFragmentTransaction.commit();
            }
        });



    }
}