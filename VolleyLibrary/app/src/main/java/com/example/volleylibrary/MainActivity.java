package com.example.volleylibrary;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Method;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainTag";
    RequestQueue requestQueue;
    ArrayList<Post> posts=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //sending a request to the server
        //Request.Method.GET => its an interface
        StringRequest stringRequest=new StringRequest(Request.Method.GET,
                "https://my-json-server.typicode.com/typicode/demo/posts",
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        try {
                            JSONArray jsonArray=new JSONArray(response);
                            for (int i = 0; i < jsonArray.length(); i++) {
                                JSONObject postJSONObject=jsonArray.getJSONObject(i);
                                Post post=new Post();
                                post.setId(postJSONObject.getInt("id"));
                                post.setTitle(postJSONObject.getString("title"));
                                posts.add(post);
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                        Log.i(TAG, "onResponse: " + response);

                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        // to handle errors like no internet connection
                        Log.e(TAG, "onErrorResponse: "+error.toString());
                    }
                });

        //to cancel a request you have to set a tag for it
        stringRequest.setTag(TAG);

        /* we can set retry policy:
        chand bar request ersal kone
        initialTimeoutMs => retrying time
        maxNumberRetries => number of retrying time
        backOffMultiplier => ye zaribe ke ba har bar timeout shodan ruye retrying time emal mishe
         */
        stringRequest.setRetryPolicy(new DefaultRetryPolicy(1000 , 3 , 2));

        //volley baraye ersale request ha unaro tuye queue gharar mide
        // volley also handles threads
        requestQueue= Volley.newRequestQueue(this);
        requestQueue.add(stringRequest); // => volley automatically sends the request
    }

    //vaghti user app ro mibande request ha bayad cancel shan

    @Override
    protected void onDestroy() {
        super.onDestroy();

        //tamame request ha ba in tag cancel mishan
        requestQueue.cancelAll(TAG);

    }
}