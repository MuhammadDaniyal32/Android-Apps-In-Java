package com.example.custom_checkboxs;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {
String[] Animals={"Lion","Tiger","Cat","Dog","Wolf"};
String value;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ListView listView=(ListView)findViewById(R.id.listview);
        custom_adapter custom_adapter=new custom_adapter(getApplicationContext(),Animals);
        listView.setAdapter(custom_adapter);
    }
}