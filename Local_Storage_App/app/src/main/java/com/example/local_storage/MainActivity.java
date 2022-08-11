package com.example.local_storage;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class MainActivity extends AppCompatActivity {
    EditText text1,text2;
    Button savedbtn,readbtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        text1=(EditText)findViewById(R.id.text1);
        text2=(EditText)findViewById(R.id.text2);

        savedbtn=(Button)findViewById(R.id.savedbtn);
        readbtn=(Button)findViewById(R.id.readbtn);

        savedbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String Filename=text1.getText().toString();
                String data=text2.getText().toString();
                FileOutputStream fos;
                try {
                    fos=openFileOutput(Filename, Context.MODE_PRIVATE);
                    fos.write(data.getBytes());
                    fos.close();
                    Toast.makeText(getApplicationContext(),Filename+"Saved",Toast.LENGTH_LONG).show();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

        readbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String Filename=text1.getText().toString();
                StringBuffer stringBuffer=new StringBuffer();

                try {

                    BufferedReader inputreader = new BufferedReader(new InputStreamReader(openFileInput(Filename)));
                    String inputString;
                    while ((inputString = inputreader.readLine()) != null)
                    {
                        stringBuffer.append(inputString+"\n");

                    }

                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                Toast.makeText(getApplicationContext(),stringBuffer.toString(),Toast.LENGTH_LONG).show();
            }
        });
    }
}