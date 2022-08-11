package com.example.quiz_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class Question extends AppCompatActivity {
    TextView tv;
    Button submitbutton, quitbutton;
    RadioGroup radio_g;
    RadioButton rb1,rb2,rb3,rb4;
    CheckBox chck1,chck2,chck3,chck4;

    String questions[] = {
            "Which method can be defined only once in a program?",
            "Which of these is not a bitwise operator?",
            "Which keyword is used by method to refer to the object that invoked it?",
            "Which of these keywords is used to define interfaces in Java?",
            "Which of these access specifiers can be used for an interface?",
            "Which of the following is correct way of importing an entire package ‘pkg’?",
            "What is the return type of Constructors?",
            "Which of the following package stores all the standard java classes?",
            "Which of these method of class String is used to compare two String objects for their equality?",
            "An expression involving byte, int, & literal numbers is promoted to which of these?9",
            "Which is the first objected oriented programming language ?"
    };
     String answers[] = {"main method","<=","this","interface","public","import pkg.*","None of the mentioned","java","equals()","int","C#","c#","c_sharp"};
    String opt[] = {
            "finalize method","main method","static method","private method",
            "&","&=","|=","<=",
            "import","this","catch","abstract",
            "Interface","interface","intf","Intf",
            "public","protected","private","All of the mentioned",
            "Import pkg.","import pkg.*","Import pkg.*","import pkg.",
            "int","float","void","None of the mentioned",
            "lang","java","util","java.packages",
            "equals()","Equals()","isequal()","Isequal()",
            "int","long","byte","float",
            "c#","C_sharp","C#","None of the above"
    };
    int flag=0;
    public static int marks=0,correct=0,wrong=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question);

        final TextView score = (TextView)findViewById(R.id.textView4);
        TextView textView=(TextView)findViewById(R.id.DispName);
        Intent intent = getIntent();
        String name= intent.getStringExtra("myname");

        if (name.trim().equals(""))
            textView.setText("Hello User");
        else
            textView.setText("Hello " + name);

        submitbutton=(Button)findViewById(R.id.button3);
        quitbutton=(Button)findViewById(R.id.buttonquit);
        tv=(TextView) findViewById(R.id.tvque);

        radio_g=(RadioGroup)findViewById(R.id.answersgrp);
        rb1=(RadioButton)findViewById(R.id.radioButton);
        rb2=(RadioButton)findViewById(R.id.radioButton2);
        rb3=(RadioButton)findViewById(R.id.radioButton3);
        rb4=(RadioButton)findViewById(R.id.radioButton4);
        tv.setText(questions[flag]);
        rb1.setText(opt[0]);
        rb2.setText(opt[1]);
        rb3.setText(opt[2]);
        rb4.setText(opt[3]);

        chck1 = (CheckBox) findViewById(R.id.checkBox1);
        chck2 = (CheckBox) findViewById(R.id.checkBox2);
        chck3 = (CheckBox) findViewById(R.id.checkBox3);
        chck4 = (CheckBox) findViewById(R.id.checkBox4);

        submitbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //int color = mBackgroundColor.getColor();
                //mLayout.setBackgroundColor(color);

                if(flag == 9){
                    radio_g.setVisibility(View.INVISIBLE);
                    chck1.setVisibility(View.VISIBLE);
                    chck2.setVisibility(View.VISIBLE);
                    chck3.setVisibility(View.VISIBLE);
                    chck4.setVisibility(View.VISIBLE);

                    chck1.setOnClickListener(new View.OnClickListener(){
                        @Override
                        public void onClick(View view){
                            //My logic for Button goes in here

                            if (chck1.getText() == answers[flag]){
                                correct++;
                                Toast.makeText(getApplicationContext(), chck1.getText(), Toast.LENGTH_SHORT).show();

                            }else {
                                wrong++;
                                Toast.makeText(getApplicationContext(), chck1.getText(), Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
                    chck2.setOnClickListener(new View.OnClickListener(){
                        @Override
                        public void onClick(View view){
                            //My logic for Button goes in here

                            if (chck2.getText() == answers.toString()){
                                correct++;
                                Toast.makeText(getApplicationContext(), chck2.getText(), Toast.LENGTH_SHORT).show();

                            }else {
                                wrong++;
                                Toast.makeText(getApplicationContext(), chck2.getText(), Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
                    chck3.setOnClickListener(new View.OnClickListener(){
                        @Override
                        public void onClick(View view){
                            //My logic for Button goes in here

                            if (chck3.getText() == answers.toString()){
                                correct++;
                                Toast.makeText(getApplicationContext(), chck3.getText(), Toast.LENGTH_SHORT).show();

                            }else {
                                wrong++;
                                Toast.makeText(getApplicationContext(), chck3.getText(), Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
                    chck4.setOnClickListener(new View.OnClickListener(){
                        @Override
                        public void onClick(View view){
                            //My logic for Button goes in here

                            if (chck4.getText() == answers.toString()){
                                correct++;
                                Toast.makeText(getApplicationContext(), chck4.getText(), Toast.LENGTH_SHORT).show();

                            }else {
                                wrong++;
                                Toast.makeText(getApplicationContext(), chck4.getText(), Toast.LENGTH_SHORT).show();
                            }
                        }
                    });

                    flag++;
                    chck1.setText(opt[0]);
                    chck2.setText(opt[1]);
                    chck3.setText(opt[2]);
                    chck4.setText(opt[3]);
                    if (flag < questions.length) {
                        tv.setText(questions[flag]);
                        chck1.setText(opt[flag * 4]);
                        chck2.setText(opt[flag * 4 + 1]);
                        chck3.setText(opt[flag * 4 + 2]);
                        chck4.setText(opt[flag * 4 + 3]);
                    }
                }
                else {
                    if (radio_g.getCheckedRadioButtonId() == -1) {
                        Toast.makeText(getApplicationContext(), "Please select one choice", Toast.LENGTH_SHORT).show();
                        return;
                    }
                    RadioButton uans = (RadioButton) findViewById(radio_g.getCheckedRadioButtonId());
                    String ansText = uans.getText().toString();
//                Toast.makeText(getApplicationContext(), ansText, Toast.LENGTH_SHORT).show();
                    if (ansText.equals(answers[flag])) {
                        correct++;
                        Toast.makeText(getApplicationContext(), "Correct", Toast.LENGTH_SHORT).show();
                    } else {
                        wrong++;
                        Toast.makeText(getApplicationContext(), "Wrong", Toast.LENGTH_SHORT).show();
                    }

                    flag++;
                    if (score != null)
                        score.setText("" + correct);

                    if (flag < questions.length) {
                        tv.setText(questions[flag]);
                        rb1.setText(opt[flag * 4]);
                        rb2.setText(opt[flag * 4 + 1]);
                        rb3.setText(opt[flag * 4 + 2]);
                        rb4.setText(opt[flag * 4 + 3]);
                    } else {
                        marks = correct;
                        Intent in = new Intent(getApplicationContext(), Result.class);
                        startActivity(in);
                    }
                    radio_g.clearCheck();
                }
            }
        });

        quitbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(),Result.class);
                startActivity(intent);
            }
        });
    }
}