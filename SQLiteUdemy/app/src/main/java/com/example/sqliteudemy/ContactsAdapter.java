package com.example.sqliteudemy;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ContactsAdapter extends RecyclerView.Adapter<ContactsAdapter.ContactsViewHolder> {

    private ArrayList<Contact> contacts;

    public ContactsAdapter(ArrayList<Contact> contacts){
        this.contacts=contacts;
    }

    @NonNull
    @Override
    public ContactsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ContactsViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_contact , parent ,false));
    }

    @Override
    public void onBindViewHolder(@NonNull ContactsViewHolder holder, int position) {
        holder.bind(position);
    }

    @Override
    public int getItemCount() {
        return contacts.size();
    }

    public class ContactsViewHolder extends RecyclerView.ViewHolder{

        TextView tvName , tvCell;
        public ContactsViewHolder(@NonNull View itemView) {
            super(itemView);
            tvCell=itemView.findViewById(R.id.tv_itemContact_call);
            tvName=itemView.findViewById(R.id.tv_itemContact_fullName);
        }

        public void bind(int index)
        {
            tvName.setText(contacts.get(index).getFullName());
            tvCell.setText(contacts.get(index).getCellPhone());
        }
    }

}
