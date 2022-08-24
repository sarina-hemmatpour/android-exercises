package com.example.asynctaskclass;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    EditText etNumTimes;
    TextView tvResult;
    Button btnRollDice;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etNumTimes=findViewById(R.id.et_main_numberOfTimes);
        tvResult=findViewById(R.id.tv_main_result);
        btnRollDice=findViewById(R.id.btn_main_rollDice);

        btnRollDice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                tvResult.setVisibility(View.GONE);
                int randomNum=Integer.parseInt(etNumTimes.getText().toString().trim());
//                String result=rollDice(randomNum);

                //creating a new thread
                new ProcessDiceInBackground().execute(randomNum);


            }
        });

    }


    public String rollDice(int numTimes)
    {
        int ones=0 , twos=0 , threes=0 , fours=0 , fives=0 , sixes=0;
        Random random=new Random();
        for (int i = 0; i < numTimes; i++) {
            int randomNum=random.nextInt(6)+1;
            switch (randomNum)
            {
                case 1:
                    ones++;
                    break;
                case 2:
                    twos++;
                    break;
                case 3:
                    threes++;
                    break;
                case 4:
                    fours++;
                    break;
                case 5:
                    fives++;
                    break;
                case 6:
                    sixes++;
                    break;
            }
        }

        String result="1: "+ones+"\n" +"2: "+twos+"\n" +"3: "+threes+"\n" +"4: "+fours+"\n" +"5: "+fives+"\n" +"6: "+sixes+"\n" ;
        return result;
    }

    public class ProcessDiceInBackground extends AsyncTask<Integer , Integer , String>{

        ProgressDialog dialog;
        int max=Integer.parseInt(etNumTimes.getText().toString().trim());
        @Override
        protected void onPreExecute() {
            super.onPreExecute();

            dialog=new ProgressDialog(MainActivity.this);
            dialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
            dialog.setMax(max);
            dialog.setCancelable(false);
            dialog.show();

        }

        @Override
        protected String doInBackground(Integer... integers) {

            int ones=0 , twos=0 , threes=0 , fours=0 , fives=0 , sixes=0;
            Random random=new Random();
            double currentProgress=0 , previousProgress=0 ;
            for (int i = 0; i < integers[0]; i++) {

                //progress bar
                currentProgress=(double) i/integers[0];
                if (currentProgress-previousProgress>=0.05)
                {
                    publishProgress(i); // i pass dade mishe be onProgressUpdate()
                    previousProgress=currentProgress;
                }

                int randomNum=random.nextInt(6)+1;
                switch (randomNum)
                {
                    case 1:
                        ones++;
                        break;
                    case 2:
                        twos++;
                        break;
                    case 3:
                        threes++;
                        break;
                    case 4:
                        fours++;
                        break;
                    case 5:
                        fives++;
                        break;
                    case 6:
                        sixes++;
                        break;
                }
            }

            String result="1: "+ones+"\n" +"2: "+twos+"\n" +"3: "+threes+"\n" +"4: "+fours+"\n" +"5: "+fives+"\n" +"6: "+sixes+"\n" ;


            return result;
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            super.onProgressUpdate(values);
            dialog.setProgress(values[0]);
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            tvResult.setText("<<RESULT>> \n" + s);
            dialog.dismiss();
            tvResult.setVisibility(View.VISIBLE);
            Toast.makeText(MainActivity.this, "Successfully DONE!", Toast.LENGTH_SHORT).show();
        }
    }
}