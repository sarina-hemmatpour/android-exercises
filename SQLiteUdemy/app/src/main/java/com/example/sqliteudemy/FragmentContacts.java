package com.example.sqliteudemy;

import android.database.SQLException;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class FragmentContacts extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_contacts , container , false);

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        RecyclerView rvContacts=getView().findViewById(R.id.rv_fragContacts_contacts);

        ArrayList<Contact> contacts = new ArrayList<>();
        try {
            ContactsDB contactsDB=new ContactsDB(getContext());
            contactsDB.open();

            contacts=contactsDB.getData();

            contactsDB.close();
        }
        catch (SQLException e)
        {
            Toast.makeText(this.getContext(), e.getMessage(), Toast.LENGTH_SHORT).show();
        }

        ContactsAdapter adapter=new ContactsAdapter(contacts);
        rvContacts.setLayoutManager(new LinearLayoutManager(this.getContext() , RecyclerView.VERTICAL , false));
        rvContacts.setAdapter(adapter);
    }
}
