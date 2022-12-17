package com.example.exoplayertutorial;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.google.android.exoplayer2.ExoPlayer;
import com.google.android.exoplayer2.MediaItem;
import com.google.android.exoplayer2.ui.PlayerView;

public class MainActivity extends AppCompatActivity {

    private ExoPlayer player;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        PlayerView playerView=findViewById(R.id.playerView_main);
        player = new ExoPlayer.Builder(MainActivity.this).build();

        // Build the media item.
        MediaItem mediaItem = MediaItem.fromUri("http://commondatastorage.googleapis.com/gtv-videos-bucket/sample/ForBiggerFun.mp4");
        // Set the media item to be played.
        player.setMediaItem(mediaItem);
        // Prepare the player.
        player.prepare();

        playerView.setPlayer(player);
        player.setPlayWhenReady(true);

        // Start the playback.
        player.play();

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        player.release();
    }

}