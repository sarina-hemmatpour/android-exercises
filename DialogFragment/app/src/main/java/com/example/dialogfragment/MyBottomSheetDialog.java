package com.example.dialogfragment;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.google.android.material.bottomsheet.BottomSheetDialogFragment;

public class MyBottomSheetDialog extends BottomSheetDialogFragment {

    MyDialog.MyDialogEventListener eventListener;

    private static final String EXTRA_KEY_DATA ="201";

    public static String getExtraKeyData() {
        return EXTRA_KEY_DATA;
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        eventListener=(MyDialog.MyDialogEventListener) context;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.dialog_fragment , container , false);


        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        EditText etData=getView().findViewById(R.id.etData);
        Button btnOk=getView().findViewById(R.id.btnOk);
        Button btnCancel=getView().findViewById(R.id.btnCancel);

        //defaultText
        String defaultData=getArguments().getString(EXTRA_KEY_DATA);
        if (defaultData.length()>0)
        {
            etData.setText(defaultData);
        }


        //actions
        btnOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (etData.length()>0)
                {
                    eventListener.onOkButtonClicked(etData.getText().toString().trim());
                }
                else
                {
                    Toast.makeText(getContext(), "Fill The Field", Toast.LENGTH_SHORT).show();
                }
                dismiss();
            }
        });

        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getContext(), "Dialog Canceled", Toast.LENGTH_SHORT).show();
                dismiss();
            }
        });
    }

    public static MyBottomSheetDialog newInstance(String data) {

        Bundle args = new Bundle();
        args.putString(MyBottomSheetDialog.getExtraKeyData() , data);
        MyBottomSheetDialog fragment = new MyBottomSheetDialog();
        fragment.setArguments(args);
        return fragment;
    }


}
