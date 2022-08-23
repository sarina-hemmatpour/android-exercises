package com.example.retrofitgetapi;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView tvList=findViewById(R.id.tv_main);

        Retrofit retrofit=new Retrofit.Builder()
                .baseUrl("https://jsonplaceholder.typicode.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        RetrofitApiService retrofitApiService=retrofit.create(RetrofitApiService.class);

        Call<ArrayList<Post>> call=retrofitApiService.getPosts();

        call.enqueue(new Callback<ArrayList<Post>>() {
            @Override
            public void onResponse(Call<ArrayList<Post>> call, Response<ArrayList<Post>> response) {

                if(!response.isSuccessful())
                {
                    tvList.setText(String.valueOf(response.code()));
                    return;
                }

                ArrayList<Post> posts=response.body();

                String txt="";
                for (Post post:posts)
                {
                    txt+="UserId: " + post.getUserId() +"\n";
                    txt+="Id: " + post.getId() +"\n";
                    txt+="Title: " + post.getTitle() +"\n";
                    txt+="Text: " + post.getText() +"\n\n";
                }
                tvList.setText(txt);

            }

            @Override
            public void onFailure(Call<ArrayList<Post>> call, Throwable t) {
                tvList.setText(t.getMessage());
            }
        });

    }
}