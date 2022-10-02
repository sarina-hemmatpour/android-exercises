package com.example.videoviewtoturial;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.widget.MediaController;

import com.example.videoviewtoturial.databinding.ActivityMainBinding;


public class MainActivity extends AppCompatActivity {


    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        binding.videoViewMain.setVideoPath("http://videocdn.bodybuilding.com/video/mp4/62000/62792m.mp4");
        binding.videoViewMain.start();

        binding.videoViewMain.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mediaPlayer) {

                //Widget class
                MediaController mediaController=new MediaController(MainActivity.this);
                mediaController.setMediaPlayer(binding.videoViewMain);

                binding.videoViewMain.setMediaController(mediaController);
                mediaController.setAnchorView(binding.videoViewMain);
            }
        });


        binding.videoViewMain.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mediaPlayer) {

            }
        });

        binding.videoViewMain.setOnErrorListener(new MediaPlayer.OnErrorListener() {
            @Override
            public boolean onError(MediaPlayer mediaPlayer, int i, int i1) {
                return false;
            }
        });

//        binding.videoViewMain.getCurrentPosition();
//        binding.videoViewMain.getDuration();
//        binding.videoViewMain.pause();
//        binding.videoViewMain.seekTo(10000);

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        binding.videoViewMain.stopPlayback();
    }
}