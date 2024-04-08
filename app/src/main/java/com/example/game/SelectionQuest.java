package com.example.game;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SelectionQuest extends AppCompatActivity {

    private Button btnLevel1, btnLevel2,btnLevel3, btnLevel4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);

        setContentView(R.layout.activity_selection_quest);



        btnLevel1 = findViewById(R.id.btnLevel1);

        btnLevel1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SelectionQuest.this, Quest1.class);
                startActivity(intent);
            }
        });

        btnLevel3 = findViewById(R.id.btnLevel3);

        btnLevel3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SelectionQuest.this, Level3Activity.class);
                startActivity(intent);
            }
        });

    }
}