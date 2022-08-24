package com.example.textfilesinandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class MainActivity extends AppCompatActivity {

    EditText etSurname , etName;
    TextView tvData;
    private ArrayList<Person> people;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etSurname=findViewById(R.id.et_main_surname);
        etName=findViewById(R.id.et_main_name);
        tvData=findViewById(R.id.tv_main_data);

        people=new ArrayList<>();
        readData();
        loadData();
    }

    public void readData()
    {
        File file=getApplicationContext().getFileStreamPath("Data.txt");
        String line;

        if (file.exists())
        {
            try {
                InputStreamReader inputStreamReader=new InputStreamReader(openFileInput("Data.txt"));
                BufferedReader reader=new BufferedReader(inputStreamReader);

                while ((line=reader.readLine())!=null)
                {
                    StringTokenizer tokenizer=new StringTokenizer(line , ",");
                    people.add(new Person(tokenizer.nextToken().trim() ,
                            tokenizer.nextToken().trim()));
                }

                reader.close();
            }
            catch (IOException e)
            {
                Toast.makeText(this, e.getMessage(), Toast.LENGTH_SHORT).show();
            }

        }
    }
    public void loadData()
    {
        for (Person person: people)
        {
            showData(person.getName() , person.getSurname());
        }
    }

    public void btnAddData(View v)
    {
        if (etName.length()>0 && etSurname.length()>0)
        {
            String name=etName.getText().toString().trim();
            String surname=etSurname.getText().toString().trim();

            people.add(new Person(name , surname));

            showData(name , surname);
        }
        else
        {
            Toast.makeText(this, "Complete all the fields", Toast.LENGTH_SHORT).show();
        }

        etName.setText("");
        etSurname.setText("");

    }

    public void showData(String name , String surname)
    {
        String txt=tvData.getText().toString().trim() +"\n"+name+" "+surname;
        tvData.setText(txt);
    }
    public void btnSaveData(View v) throws IOException {
        //saving data to a file
        try {
            FileOutputStream fileOutputStream=openFileOutput("Data.txt" , MODE_PRIVATE);
            OutputStreamWriter writer=new OutputStreamWriter(fileOutputStream);

            for(Person person:people)
            {
                writer.write(person.getName()+","+person.getSurname()+"\n");
            }

            writer.flush();
            fileOutputStream.close();

            Toast.makeText(this, "Successfully saved!", Toast.LENGTH_SHORT).show();

        } catch (FileNotFoundException e) {
            Toast.makeText(this, e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }

}