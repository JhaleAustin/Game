package com.example.game;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Bundle;
import android.view.DragEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;
import android.os.Bundle;
import android.view.DragEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

public class Level3Activity extends AppCompatActivity {

    private ImageView organismImageView;
    private ImageView prokaryoteTarget;
    private ImageView eukaryoteTarget;

    private int[] organismImages = {
            R.drawable.bacteria,
            R.drawable.archaea,
            R.drawable.plant,
            R.drawable.animal,
            R.drawable.protist,
            R.drawable.fungi
    };

    private Random random = new Random();
    private int currentImageIndex = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level3);

        organismImageView = findViewById(R.id.organismImageView);
        prokaryoteTarget = findViewById(R.id.prokaryoteTarget);
        eukaryoteTarget = findViewById(R.id.eukaryoteTarget);

        setRandomOrganismImage();

        organismImageView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                v.startDrag(null, new View.DragShadowBuilder(v), null, 0);
                return true;
            }
        });

        prokaryoteTarget.setOnDragListener(new View.OnDragListener() {
            @Override
            public boolean onDrag(View v, DragEvent event) {
                switch (event.getAction()) {
                    case DragEvent.ACTION_DROP:
                        if (isProkaryote()) {
                            Toast.makeText(Level3Activity.this, "Correct! It's a prokaryote.", Toast.LENGTH_SHORT).show();
                        } else {
                            Toast.makeText(Level3Activity.this, "Incorrect! It's not a prokaryote.", Toast.LENGTH_SHORT).show();
                        }
                        setRandomOrganismImage();
                        return true;
                }
                return true;
            }
        });

        eukaryoteTarget.setOnDragListener(new View.OnDragListener() {
            @Override
            public boolean onDrag(View v, DragEvent event) {
                switch (event.getAction()) {
                    case DragEvent.ACTION_DROP:
                        if (isEukaryote()) {
                            classifyEukaryote();
                        } else {
                            Toast.makeText(Level3Activity.this, "Incorrect! It's not a eukaryote.", Toast.LENGTH_SHORT).show();
                            setRandomOrganismImage();
                        }
                        return true;
                }
                return true;
            }
        });
    }

    private void setRandomOrganismImage() {
        currentImageIndex = random.nextInt(organismImages.length);
        organismImageView.setImageResource(organismImages[currentImageIndex]);
    }

    private boolean isProkaryote() {
        return currentImageIndex % 2 != 0;
    }

    private boolean isEukaryote() {
        return currentImageIndex % 2 == 0;
    }

    private void classifyEukaryote() {
        Toast.makeText(Level3Activity.this, "Eukaryote! Classify further.", Toast.LENGTH_SHORT).show();
        // Implement further classification logic for eukaryotes
    }
}
