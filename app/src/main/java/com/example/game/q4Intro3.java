package com.example.game;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class q4Intro3 extends AppCompatActivity {

    private ImageView imageView;
    private ImageButton startQ4lvl3;
    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_q4_intro3);

        imageView = findViewById(R.id.startQ4lvl3);

        startQ4lvl3 = findViewById(R.id.startQ4lvl3);
        // Delay changing the image by 1 second
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                changeImage();
            }
        }, 1000); // 1000 milliseconds = 1 second



        startQ4lvl3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Intent intent = new Intent(Menu.this, SelectionQuest.class);

                Intent intent = new Intent(q4Intro3.this,   Quest4_lvl3.class);
                startActivity(intent);

            }
        });
    }

    private void changeImage() {
        // Change the image here
        imageView.setImageResource(R.drawable.q4Intro3); // Replace new_image with your new image resource
        startQ4lvl3.setVisibility(View.VISIBLE);
    }
}
