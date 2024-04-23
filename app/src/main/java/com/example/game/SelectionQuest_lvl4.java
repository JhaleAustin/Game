package com.example.game;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SelectionQuest_lvl4 extends AppCompatActivity {

    Button lvl1,lvl2,lvl3,lvl4,lvl5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);

        setContentView(R.layout.activity_selection_quest_lvl4);


        lvl1 = findViewById(R.id.lvl1);

        lvl1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Intent intent = new Intent(Menu.this, SelectionQuest.class);

                Intent intent = new Intent(SelectionQuest_lvl4.this,   Quest4_lvl1.class);
                startActivity(intent);

            }
        });



        lvl2 = findViewById(R.id.lvl2);

        lvl2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Intent intent = new Intent(Menu.this, SelectionQuest.class);

                Intent intent = new Intent(SelectionQuest_lvl4.this,   Quest4_lvl2.class);
                startActivity(intent);

            }
        });


        lvl3 = findViewById(R.id.lvl3);

        lvl3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Intent intent = new Intent(Menu.this, SelectionQuest.class);

                Intent intent = new Intent(SelectionQuest_lvl4.this,   Quest4_lvl3.class);
                startActivity(intent);

            }
        });
    }
}