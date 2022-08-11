package com.example.login_registration_with_db;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

public class Welcome extends AppCompatActivity {
   /* dbhelper databaseHelper;
    String name,pass;*/
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        /*Intent i = getIntent();
        name=i.getStringExtra("user_name");
        pass=i.getStringExtra("pass");*/
    }
}