package com.example.sqliteudemy;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.database.SQLException;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {

    TextInputEditText etFullName , etCell;
    Button btnSubmit , btnShow , btnEdit , btnDelete;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etFullName=findViewById(R.id.et_main_fullName);
        etCell=findViewById(R.id.et_main_cellPhone);

        btnSubmit=findViewById(R.id.btn_main_submit);
        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    if (etCell.length()>0 && etFullName.length()>0)
                    {
                        ContactsDB contactsDB=new ContactsDB(MainActivity.this);
                        contactsDB.open();

                        contactsDB.createEntity(etFullName.getText().toString().trim() ,
                                etCell.getText().toString().trim());

                        contactsDB.close();
                        Toast.makeText(MainActivity.this, "Successfully added", Toast.LENGTH_SHORT).show();

                        etFullName.setText("");
                        etCell.setText("");
                    }else
                    {
                        Toast.makeText(MainActivity.this, "Complete the fields!", Toast.LENGTH_SHORT).show();
                    }
                }
                catch (SQLException e)
                {
                    Toast.makeText(MainActivity.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                }
            }
        });

        btnEdit=findViewById(R.id.btn_main_edit);
        btnEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    if (etCell.length()>0 && etFullName.length()>0)
                    {
                        ContactsDB contactsDB=new ContactsDB(MainActivity.this);
                        contactsDB.open();

                        contactsDB.updateEntry("1",etFullName.getText().toString().trim() ,
                                etCell.getText().toString().trim());

                        contactsDB.close();

                        Toast.makeText(MainActivity.this, "Successfully edited", Toast.LENGTH_SHORT).show();

                        etFullName.setText("");
                        etCell.setText("");
                    }else
                    {
                        Toast.makeText(MainActivity.this, "Complete the fields!", Toast.LENGTH_SHORT).show();
                    }
                }
                catch (SQLException e)
                {
                    Toast.makeText(MainActivity.this, e.getMessage(), Toast.LENGTH_SHORT).show();

                }
            }
        });

        btnDelete=findViewById(R.id.btn_main_delete);
        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {

                        ContactsDB contactsDB=new ContactsDB(MainActivity.this);
                        contactsDB.open();

                        contactsDB.deleteEntry("1");

                        contactsDB.close();

                        Toast.makeText(MainActivity.this, "Successfully deleted", Toast.LENGTH_SHORT).show();
                        etFullName.setText("");
                        etCell.setText("");
                }
                catch (SQLException e)
                {
                    Toast.makeText(MainActivity.this, e.getMessage(), Toast.LENGTH_SHORT).show();

                }
            }
        });

        btnShow=findViewById(R.id.btn_main_show);
        btnShow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                etFullName.setText("");
                etCell.setText("");
                FragmentTransaction fragmentTransaction=getSupportFragmentManager().beginTransaction();
                fragmentTransaction.add(R.id.frame_fragmentContainer , new FragmentContacts());
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
            }
        });

    }
}