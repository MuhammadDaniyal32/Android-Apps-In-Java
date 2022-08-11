package com.example.toggelbutton_app;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.Switch;
import android.widget.Toast;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {
Button t_btn1,t_btn2,btn1,btn2;
Switch s_btn1,s_btn2;
RadioButton r_btn1,r_btn2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        t_btn1=(ToggleButton)findViewById(R.id.t_btn1);
        t_btn2=(ToggleButton)findViewById(R.id.t_btn2);
        s_btn1=(Switch)findViewById(R.id.s_btn1);
        s_btn2=(Switch)findViewById(R.id.s_btn2);
        btn1=(Button)findViewById(R.id.btn1);
        r_btn1=(RadioButton) findViewById(R.id.r_btn1);
        r_btn2=(RadioButton) findViewById(R.id.r_btn2);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String status ="ToggleButton_1:"+t_btn1.getText()+"\n"+"ToggleButton_2:"+t_btn2.getText();

                Toast.makeText(getApplicationContext(),status,Toast.LENGTH_LONG).show();
            }
        });

        btn2=(Button)findViewById(R.id.btn2);
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String status_sbtn1,status_sbtn2,status_rbtn1,status_rbtn2;

                if(r_btn1.isChecked()) {
                    status_rbtn1 = "Male";
                }
                if(r_btn2.isChecked()) {
                    status_rbtn2 = "Female";
                }

                if(s_btn1.isChecked())

                    status_sbtn1=s_btn1.getTextOn().toString();

                else

                    status_sbtn1=s_btn1.getTextOff().toString();


                if(s_btn2.isChecked())

                    status_sbtn2=s_btn2.getTextOn().toString();

                else

                    status_sbtn2=s_btn2.getTextOff().toString();


                Toast.makeText(getApplicationContext(),"Wifi:"+status_sbtn1+"\n Radio:"+status_sbtn2+"\n"+status_rbtn1+"\n"+status_rbtn2,Toast.LENGTH_LONG).show();


            }
        });

    }
}