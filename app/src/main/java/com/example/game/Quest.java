package com.example.game;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.pm.ActivityInfo;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class Quest extends AppCompatActivity {

    private ImageView imageView;
    private Button buttonBird, buttonCat, buttonAirplane;

    private ScaleGestureDetector scaleGestureDetector;
    private float mScaleFactor = 1.0f;

    private float mLastTouchX, mLastTouchY;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);

        setContentView(R.layout.activity_quest);

        imageView = findViewById(R.id.imageView);
        buttonBird = findViewById(R.id.button);
        buttonCat = findViewById(R.id.button2);
        buttonAirplane = findViewById(R.id.button3);

        // Scale Gesture Detector for pinch zoom
        scaleGestureDetector = new ScaleGestureDetector(this, new ScaleListener());

        // Move the map (panning) on touch
        imageView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                scaleGestureDetector.onTouchEvent(event);

                float x = event.getX();
                float y = event.getY();

                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        mLastTouchX = x;
                        mLastTouchY = y;
                        break;
                    case MotionEvent.ACTION_MOVE:
                        float deltaX = x - mLastTouchX;
                        float deltaY = y - mLastTouchY;
                        mLastTouchX = x;
                        mLastTouchY = y;
                        // Update the position of the ImageView
                        ConstraintLayout.LayoutParams layoutParams = (ConstraintLayout.LayoutParams) imageView.getLayoutParams();
                        layoutParams.leftMargin = (int) (imageView.getLeft() + deltaX);
                        layoutParams.topMargin = (int) (imageView.getTop() + deltaY);
                        imageView.setLayoutParams(layoutParams);
                        break;
                    case MotionEvent.ACTION_UP:
                        // Detect object click here
                        detectObjectClick(x, y);
                        break;
                }

                return true;
            }
        });

        // Button click listeners to save object categories
        buttonBird.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Save object as bird category
                // You can implement your saving logic here
                Toast.makeText(Quest.this, "Object saved as Bird", Toast.LENGTH_SHORT).show();
            }
        });

        buttonCat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Save object as cat category
                // You can implement your saving logic here
                Toast.makeText(Quest.this, "Object saved as Cat", Toast.LENGTH_SHORT).show();
            }
        });

        buttonAirplane.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Save object as airplane category
                // You can implement your saving logic here
                Toast.makeText(Quest.this, "Object saved as Airplane", Toast.LENGTH_SHORT).show();
            }
        });
    }

    // Method to detect object click
    private void detectObjectClick(float x, float y) {
        // Here you can implement logic to detect which object was clicked
        // For example, you can check the color of the pixel at the clicked position
        // and determine if it corresponds to an object

        // For demonstration, let's assume the user clicked on an object and its color is red
        int color = getPixelColor((int) x, (int) y);
        if (color == getResources().getColor(R.color.red)) {
            // Object is a bird
            buttonBird.performClick(); // Simulate button click to save as bird category
        } else if (color == getResources().getColor(R.color.blue)) {
            // Object is a cat
            buttonCat.performClick(); // Simulate button click to save as cat category
        } else if (color == getResources().getColor(R.color.green)) {
            // Object is an airplane
            buttonAirplane.performClick(); // Simulate button click to save as airplane category
        }
    }

    // Method to get color of the pixel at given coordinates
    private int getPixelColor(int x, int y) {
        imageView.setDrawingCacheEnabled(true);
        Bitmap bitmap = Bitmap.createBitmap(imageView.getDrawingCache());
        imageView.setDrawingCacheEnabled(false);
        return bitmap.getPixel(x, y);
    }

    // ScaleListener for pinch zoom
    private class ScaleListener extends ScaleGestureDetector.SimpleOnScaleGestureListener {
        @Override
        public boolean onScale(ScaleGestureDetector detector) {
            mScaleFactor *= detector.getScaleFactor();
            mScaleFactor = Math.max(0.1f, Math.min(mScaleFactor, 5.0f));
            imageView.setScaleX(mScaleFactor);
            imageView.setScaleY(mScaleFactor);
            return true;
        }
    }

}
