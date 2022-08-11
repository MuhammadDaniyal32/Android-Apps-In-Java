package com.example.activity_demos;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.activity_demos.ui.main.MainActivityFragmentFragment;

public class MainActivity_fragment extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity_fragment_activity);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.container, MainActivityFragmentFragment.newInstance())
                    .commitNow();
        }
    }
}