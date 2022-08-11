package com.example.image_zooming_project;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;
import android.widget.ZoomControls;

public class MainActivity extends AppCompatActivity {
ImageView img;
ZoomControls zoom;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        img =(ImageView)findViewById(R.id.imageview);
        zoom=(ZoomControls)findViewById(R.id.zoom);

        zoom.hide();
        img.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                zoom.show();
                return false;
            }
        });
        zoom.setOnZoomInClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                float x=img.getScaleX();
                float y=img.getScaleY();
                img.setScaleY((float)(y+1));
                img.setScaleX((float)(x+1));
                Toast.makeText(getApplicationContext(),"Zoom In...",Toast.LENGTH_SHORT).show();
                zoom.hide();

            }
        });

        zoom.setOnZoomOutClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                float x=img.getScaleX();
                float y=img.getScaleY();
                if(x>1&&y>1) {
                    img.setScaleY((float) (y - 1));
                    img.setScaleX((float) (x - 1));
                    Toast.makeText(getApplicationContext(), "Zoom Out...", Toast.LENGTH_SHORT).show();
                    zoom.hide();
                }
            }
        });

    }
}