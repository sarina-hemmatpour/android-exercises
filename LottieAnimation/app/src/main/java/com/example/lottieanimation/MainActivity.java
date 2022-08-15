package com.example.lottieanimation;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.airbnb.lottie.LottieAnimationView;
import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /* auto play animation =>
        app:lottie_autoPlay="true"
         */
        ExtendedFloatingActionButton btnPlay=findViewById(R.id.btnPlay);
        LottieAnimationView imgSuccess=findViewById(R.id.lottieAnimation_success);

        btnPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                imgSuccess.playAnimation();
//                imgSuccess.setProgress(0.5f); //stops when 50% of the animation is played
//                imgSuccess.setRepeatCount(5);
                imgSuccess.resumeAnimation();
            }
        });
        imgSuccess.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                imgSuccess.pauseAnimation();
            }
        });

        imgSuccess.addAnimatorListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animator) {

            }

            @Override
            public void onAnimationEnd(Animator animator) {

            }

            @Override
            public void onAnimationCancel(Animator animator) {

            }

            @Override
            public void onAnimationRepeat(Animator animator) {
                Log.i("TAG", "onAnimationRepeat: "); //works
            }
        });
        imgSuccess.addAnimatorUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator valueAnimator) {

            }
        });


        // ///////////////////////////////////////////////////////////////////
        imgSuccess.addAnimatorListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationPause(Animator animation) {
                super.onAnimationPause(animation);
                Log.i("TAG", "onAnimationPause: "); //doesnt work
                Toast.makeText(MainActivity.this, "DO NOT PAUSE THE ANIMATION !#!#!####!", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onAnimationResume(Animator animation) {
                super.onAnimationResume(animation);
                Log.i("TAG", "onAnimationResume: "); //doesnt work
            }
        });


        imgSuccess.addAnimatorPauseListener(new Animator.AnimatorPauseListener() {
            @Override
            public void onAnimationPause(Animator animator) {
                Log.i("TAG", "onAnimationPause: "); //doesnt work:(
            }

            @Override
            public void onAnimationResume(Animator animator) {

            }
        });

    }

}