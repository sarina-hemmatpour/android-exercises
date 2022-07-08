package com.example.dialogfragment;

import android.app.Dialog;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.DialogFragment;

public class MyDialog extends DialogFragment {

    MyDialogEventListener eventListener;

    private static final String EXTRA_KEY_HINT = "281";

    public static String getExtraKeyHint() {
        return EXTRA_KEY_HINT;
    }

    @Override
    public void onAttach(@NonNull Context context) {
        eventListener=(MyDialogEventListener) context;
        super.onAttach(context);
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {

        AlertDialog.Builder builder=new AlertDialog.Builder(getContext());
        View view= LayoutInflater.from(getContext()).inflate(R.layout.dialog_fragment , null , false);
        builder.setView(view);

        //actions
        Button btnOk=view.findViewById(R.id.btnOk);
        Button btnCancel=view.findViewById(R.id.btnCancel);
        EditText etData=view.findViewById(R.id.etData);

        if (getArguments().getString(EXTRA_KEY_HINT).length()>0)
        {
            etData.setText(getArguments().getString(EXTRA_KEY_HINT));
        }

        btnOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (etData.length()>0)
                {
                    eventListener.onOkButtonClicked(etData.getText().toString().trim());
                    dismiss();
                }
                else
                {
                    Toast.makeText(getContext(), "Fill the Field.", Toast.LENGTH_SHORT).show();
                }
            }
        });

        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                eventListener.onCancelButtonClicked(etData.getText().toString().trim());
                dismiss();
            }
        });


        return builder.create();
    }


    public interface MyDialogEventListener{
        void onOkButtonClicked(String data);
        void onCancelButtonClicked(String data);
    }

    public static MyDialog newInstance(String hint) {

        Bundle args = new Bundle();
        args.putString(getExtraKeyHint() , hint);
        MyDialog fragment = new MyDialog();
        fragment.setArguments(args);
        return fragment;
    }

}
