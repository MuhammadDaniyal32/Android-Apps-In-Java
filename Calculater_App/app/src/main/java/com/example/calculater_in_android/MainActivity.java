package com.example.calculater_in_android;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import java.io.CharConversionException;

public class MainActivity extends AppCompatActivity {
public String str="";
Character operator = 'q';
double i, num, numtemp;
EditText showresult;
RadioButton radian;
RadioButton deg;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        showresult= (EditText)findViewById(R.id.editbox);
        radian=(RadioButton)findViewById(R.id.radian_radio);
        deg=(RadioButton)findViewById(R.id.deg_radio);
    }
    public void insert(int j)
    {
        str =str+Integer.toString(j);
        num = Integer.valueOf(str).intValue();
        showresult.setText(str);
    }
    public void  delete()
    {
        str="";
        operator='q';
        num=0.0;
        numtemp=0.0;
        showresult.setText("");
    }
    public void perform()
    {
        str="";
        numtemp=num;
    }
    public void calculate()
    {
        if(operator=='+')
        {
            num+=numtemp;
        }
        else if(operator=='-')
        {
            num-=numtemp;
        }
        else if(operator=='*')
        {
            num *= numtemp;
        }
        else if(operator=='/')
        {
            try
            {
                num = numtemp / num;
            }
            catch (Exception ex)
            {
                System.out.println("Not possible!");
            }
        }
        else if(operator=='x')
        {
            num=Math.pow(numtemp,num);
        }
        else if(operator=='E')
        {
             //num = (int) Math.pow(num,numtemp);
            double result= num;
            for (int i = 1; i > numtemp; i++)
            { num +=0; }

            //for (int i = 1; i < y; i++) { result = result * x; }

        }

        showresult.setText(""+num);

    }
    public void btn7Clicked(View view) {
        insert(7);
    }

    public void btn8Clicked(View view) {
        insert(8);
    }

    public void btn9Clicked(View view) {
        insert(9);
    }

    public void btnclearClicked(View view) {
        delete();
    }

    public void btn4Clicked(View view) {
        insert(4);
    }

    public void btn5Clicked(View view) {
        insert(5);
    }

    public void btn6Clicked(View view) {
        insert(6);
    }

    public void btnplusClicked(View view) {
        perform();
        operator='+';
    }

    public void btn1Clicked(View view) {
        insert(1);
    }

    public void btn2Clicked(View view) {
        insert(2);
    }

    public void btn3Clicked(View view) {
        insert(3);
    }

    public void btnminusClicked(View view) {
        perform();
        operator='-';
    }

    public void btnequalClicked(View view) {
        calculate();
    }

    public void btndivideClicked(View view) {
        perform();
        operator='/';
    }

    public void btnmultiClicked(View view) {
        perform();
        operator='*';
    }

    public void btn0Clicked(View view) {
        if(showresult.length()>0)
        {
            insert(0);
        }
    }

    public void sine(View view) {
        if(deg.isChecked()==true)
        {
            num=num*Math.PI/180;
            double a =Math.sin(num);
            showresult.setText(""+a);
        }
        else if(radian.isChecked()==true)
        {
            double a=Math.sin(num);
            showresult.setText(""+a);
        }

    }

    public void cons(View view) {

        if(deg.isChecked()==true)
        {
            num=num*Math.PI/180;
            double a = Math.cos(num);
            showresult.setText(""+a);
        }
        else if(radian.isChecked()==true)
        {
            double a = Math.cos(num);
            //a=a*3.1416/180;
            showresult.setText(""+a);
        }
    }

    public void tan(View view) {
        if(deg.isChecked()==true)
        {
            num=num*Math.PI/180;
            double a = Math.tan(num);
            showresult.setText(""+a);
        }
        else if(radian.isChecked()==true)
        {
            double a=Math.tan(num);
            showresult.setText(""+a);
        }
    }

    public void back(View view) {
        if (str.length() >=1 )
        {
            str = str.substring(0, str.length() - 1);
            showresult.setText(str);
        }
        else if (str.length()==0 )
        {
            showresult.setText("");
        }
    }

    public void dot(View view) {
        if(!str.contains(".")&&showresult.length()>0) {
            str = str + String.valueOf(".");
            num = Double.valueOf(str).doubleValue();
            showresult.setText(showresult.getText()+".");
        }

    }

    public void square(View view) {
        double a = Math.pow(num,2);
        showresult.setText(""+a);
    }

    public void power(View view) {
        perform();
        operator='x';
    }

    public void root(View view) {
        double a = Math.sqrt(num);
        showresult.setText(""+a);
    }

    public void dzeroclicked(View view) {
        if(showresult.length()>0)
        {
            insert(0);
            insert(0);
        }
    }

    public void sinh(View view) {
        if(deg.isChecked()==true)
        {
            num=num*Math.PI/180;
            double a =Math.sinh(num);
            showresult.setText(""+a);
        }
        else if(radian.isChecked()==true)
        {
            double a=Math.sinh(num);
            showresult.setText(""+a);
        }
    }

    public void cosh(View view) {
        if(deg.isChecked()==true)
        {
            num=num*Math.PI/180;
            double a =Math.cosh(num);
            showresult.setText(""+a);
        }
        else if(radian.isChecked()==true)
        {
            double a=Math.cosh(num);
            showresult.setText(""+a);
        }
    }

    public void tanh(View view) {
        if(deg.isChecked()==true)
        {
            num=num*Math.PI/180;
            double a =Math.tanh(num);
            showresult.setText(""+a);
        }
        else if(radian.isChecked()==true)
        {
            double a=Math.tanh(num);
            showresult.setText(""+a);
        }
    }

    public void asin(View view) {
        if(deg.isChecked()==true)
        {
            num=num*Math.PI/180;
            double a =Math.asin(num);
            showresult.setText(""+a);
        }
        else if(radian.isChecked()==true)
        {
            double a=Math.asin(num);
            showresult.setText(""+a);
        }
    }

    public void acos(View view) {
        if(deg.isChecked()==true)
        {
            num=num*Math.PI/180;
            double a =Math.acos(num);
            showresult.setText(""+a);
        }
        else if(radian.isChecked()==true)
        {
            double a=Math.acos(num);
            showresult.setText(""+a);
        }
    }

    public void atan(View view) {
        if(deg.isChecked()==true)
        {
            num=num*Math.PI/180;
            double a =Math.atan(num);
            showresult.setText(""+a);
        }
        else if(radian.isChecked()==true)
        {
            double a=Math.atan(num);
            showresult.setText(""+a);
        }
    }

    public void x10(View view) {
        int a = (int) Math.pow(10,num);
        showresult.setText(""+a);

    }

    public void exp(View view) {
        perform();
        operator='E';
    }

    public void log(View view) {
        double a=Math.log10(num);
        showresult.setText(""+a);
    }
}