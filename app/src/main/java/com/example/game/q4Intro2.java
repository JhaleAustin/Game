package com.example.game;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

public class q4Intro2 extends AppCompatActivity {
    private ImageView imageView;
    private ImageButton startQ4lvl2;

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_q4_intro3);
        setContentView(R.layout.activity_q4_intro2);
        imageView = findViewById(R.id.startQ4lvl3);
        startQ4lvl2 = findViewById(R.id.button38);



        startQ4lvl2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Intent intent = new Intent(Menu.this, SelectionQuest.class);
                imageView.setImageResource(R.drawable.q4intro2_1); // Replace new_image with your new image resource
                startQ4lvl2.setVisibility(View.INVISIBLE);
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        Intent intent = new Intent(q4Intro2.this,   Quest4_lvl2.class);
                        startActivity(intent);

                    }
                }, 1000); // 1000 milliseconds = 1 second
            }
        });
    }
}