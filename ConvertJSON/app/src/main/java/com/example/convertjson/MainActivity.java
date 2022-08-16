package com.example.convertjson;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //creating the body of the request that we want to send to the server

        JSONObject jsonObject=new JSONObject();
        try {
            jsonObject.put("first_name" , "ali");
            jsonObject.put("last_name" , "ahmadi");

            JSONObject jsonCourse=new JSONObject();
            jsonCourse.put("title" , "android");
            jsonCourse.put("xp" , 120);

            JSONArray tag=new JSONArray();
            tag.put("android");
            tag.put("java");
            tag.put("kotlin");

            jsonCourse.put("tag" , tag);

            jsonObject.put("course" ,jsonCourse);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        JSONObject jsonObject2=new JSONObject();
        try {
            jsonObject2.put("first_name" , "sarina");
            jsonObject2.put("last_name" , "hemmati");

            JSONObject jsonCourse2=new JSONObject();
            jsonCourse2.put("title" , "android");
            jsonCourse2.put("xp" , 300);

            JSONArray tag=new JSONArray();
            tag.put("android");
            tag.put("java");
            tag.put("kotlin");

            jsonCourse2.put("tag" , tag);

            jsonObject2.put("course" ,jsonCourse2);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        JSONArray jsonArray=new JSONArray();
        jsonArray.put(jsonObject);
        jsonArray.put(jsonObject2);

        Log.i("MainTag", "onCreate: " + jsonArray);


        //convert this JSON array into java codes
        ArrayList<Student> students=new ArrayList<>();
        for (int i = 0; i < jsonArray.length(); i++) {
            try {
                JSONObject studentJSONObject = jsonArray.getJSONObject(i);
                Student newStudent = new Student();
                newStudent.setFirst_name(studentJSONObject.getString("first_name"));
                newStudent.setLast_name(studentJSONObject.getString("last_name"));
                //course

                JSONObject courseJASONObject = studentJSONObject.getJSONObject("course");
                Course course = new Course();
                course.setTitle(courseJASONObject.getString("title"));
                course.setXp(courseJASONObject.getInt("xp"));

                JSONArray tagJSONArray = courseJASONObject.getJSONArray("tag");
                //tags

                for (int j = 0; j < tagJSONArray.length(); j++) {
                    course.getTag().add(tagJSONArray.getString(j));
                }

                newStudent.setCourse(course);

                students.add(newStudent);

            } catch (JSONException e) {
                e.printStackTrace();
            }
        }

        Log.i("TAG2", "onCreate: " + students);
        

        //double shift :)))))))))))))))))))))



    }
}