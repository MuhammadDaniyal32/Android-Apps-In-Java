package com.example.stop_watch;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.TextView;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {
private int second =0;
private boolean running;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        runtimer();
    }
private void runtimer()
{
    final TextView textView=(TextView) findViewById(R.id.time_view);
    final Handler handler=new Handler();
    handler.post(new Runnable() {
        @Override
        public void run() {
            int hours=second/3600;
            int minutes=(second%3600)/60;
            int secs=second%60;
            String time = String.format(Locale.getDefault(),
                    "%d:%02d:%02d",hours,minutes,secs);
            textView.setText(time);
            if(running){
                second++;
            }
            handler.postDelayed(this,1000);

        }
    });
}
    public void strtbtn(View view) {
        running=true;
    }

    public void Stopbtn(View view) {
        running=false;
    }

    public void Restbtn(View view) {
        running=false;
        second=0;
    }
}