package com.example.game;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.widget.VideoView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Enforce landscape orientation
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);

        setContentView(R.layout.activity_main);

        VideoView videoView = findViewById(R.id.videoView);

        // Set the video file in the raw folder (assuming it's named "splash_2.mp4")
        Uri videoUri = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.splash_2);
        videoView.setVideoURI(videoUri);

        // Set looping and start the video
        videoView.setOnPreparedListener(mp -> {
            mp.setLooping(true);
            mp.start();
        });

        // Start the menu activity after a delay of 8 seconds
        new Handler().postDelayed(() -> {
            Intent intent = new Intent(MainActivity.this, Menu.class);
            startActivity(intent);
            // Finish current activity to prevent returning back to splash screen
            finish();
        }, 8000); // 8 seconds delay
    }
}
