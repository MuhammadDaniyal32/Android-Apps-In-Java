package com.example.accelemeter_sensor_project;

import androidx.appcompat.app.AppCompatActivity;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity {
SensorManager sm =null;
TextView textView1=null;
List list;

SensorEventListener sen =new SensorEventListener(){

    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {
        float[] values = sensorEvent.values;
        textView1.setText("X:"+values[0]+"\n Y:"+values[1]+"\n Z:"+values[2]);

    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {

    }
};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sm =(SensorManager)getSystemService(SENSOR_SERVICE);
        textView1=(TextView)findViewById(R.id.textview1);
        list=sm.getSensorList(Sensor.TYPE_ACCELEROMETER);
        if(list.size()>0)
        {
            sm.registerListener(sen,(Sensor)list.get(0),SensorManager.SENSOR_DELAY_NORMAL);

        }
        else
        {
            Toast.makeText(getApplicationContext(),"Error",Toast.LENGTH_LONG).show();
        }
    }
    @Override
    protected void onStop()
    {
        if(list.size()>0)
        {
            sm.unregisterListener(sen);

        }
        super.onStop();
    }
}