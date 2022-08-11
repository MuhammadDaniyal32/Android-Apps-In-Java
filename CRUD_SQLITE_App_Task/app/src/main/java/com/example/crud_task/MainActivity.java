package com.example.crud_task;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
sqlhelper db;
EditText nametxt,citytxt,sechertxt;
CheckBox karcheck,lahcheck,Multcheck;
RadioButton radioButton;
RadioGroup group;
Button add,update,view,delete;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nametxt=(EditText)findViewById(R.id.nametxt);
        citytxt=(EditText)findViewById(R.id.citytxt);
        sechertxt=(EditText)findViewById(R.id.sechertxt);
        group=(RadioGroup) findViewById(R.id.group);
       /* malebtn=(RadioButton)findViewById(R.id.malebtn);
        femalebtn=(RadioButton)findViewById(R.id.femalebtn);*/
        karcheck=(CheckBox)findViewById(R.id.karcheck);
        lahcheck=(CheckBox)findViewById(R.id.lahcheck);
        Multcheck=(CheckBox)findViewById(R.id.Multcheck);
        add=(Button) findViewById(R.id.add);
        view=(Button) findViewById(R.id.view);
        delete=(Button) findViewById(R.id.delete);
        update=(Button) findViewById(R.id.update);

        db=new sqlhelper(this);

        AddData();
        viewAll();
        deletedate();
        updatedate();
    }
public void AddData()
{
    add.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            radioButton  = (RadioButton)findViewById(group.getCheckedRadioButtonId());
            String Gender = radioButton.getText().toString();
            String Places = "";

            if (karcheck.isChecked()) {
                Places += karcheck.getText().toString()+",";
            }
            if (lahcheck.isChecked()) {
                Places += lahcheck.getText().toString()+",";
            }

            if (Multcheck.isChecked()) {
                Places += Multcheck.getText().toString()+",";
            }


            boolean isInserted = db.insertdata(nametxt.getText().toString(),
                    Gender,citytxt.getText().toString(), Places);
            if(isInserted == true)
            {
                Toast.makeText(MainActivity.this, "Data Inserted",Toast.LENGTH_LONG).show();
                clear_fields();
            }
            else
            {
                Toast.makeText(MainActivity.this, "Sorry, Need to Check :(", Toast.LENGTH_LONG).show();

            }
        }
    });
}
    public void viewAll()
    {
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Cursor res = db.getalldata();
                if(res.getCount() == 0)
                {
                    ShowMessage("Error","Nothing Found");
                    return;
                }
                StringBuffer buffer = new StringBuffer();
                while (res.moveToNext())
                {
                    buffer.append("Id: "+ res.getString(0)+"\n");
                    buffer.append("Name: "+ res.getString(1)+"\n");
                    buffer.append("Gender: "+ res.getString(2)+"\n");
                    buffer.append("City: "+ res.getString(3)+"\n");
                    buffer.append("Places: "+ res.getString(4)+"\n\n");
                }
                ShowMessage("Data",buffer.toString());
            }
        });
    }
    public void ShowMessage(String title, String Message)
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(Message);
        builder.show();
    }
    public void deletedate()
    {
        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Integer deleterows = db.deletedata(sechertxt.getText().toString());
                if(deleterows>0)
                {
                    Toast.makeText(MainActivity.this,"Data Deleted!",Toast.LENGTH_LONG).show();
                    clear_fields();
                }
                else
                {
                    Toast.makeText(MainActivity.this,"Data Not Deleted!!!!",Toast.LENGTH_LONG).show();

                }
            }
        });

    }
    public void clear_fields()
    {
        sechertxt.setText("");
        citytxt.setText("");
        nametxt.setText("");
        group.clearCheck();
    }

    public void updatedate()
    {

            update.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (sechertxt.getText() != null) {
                        radioButton = (RadioButton) findViewById(group.getCheckedRadioButtonId());
                        String Gender = radioButton.getText().toString();
                        String Places = "";

                        if (karcheck.isChecked()) {
                            Places += karcheck.getText().toString();
                        }
                        if (lahcheck.isChecked()) {
                            Places += lahcheck.getText().toString();
                        }

                        if (Multcheck.isChecked()) {
                            Places += Multcheck.getText().toString();
                        }
                        boolean Updated = db.updatedate(sechertxt.getText().toString(), nametxt.getText().toString(), Gender, citytxt.getText().toString(), Places);
                        if (Updated == true) {
                            Toast.makeText(MainActivity.this, "Data Updated!", Toast.LENGTH_LONG).show();
                            clear_fields();
                        } else {
                            Toast.makeText(MainActivity.this, "Data Not Updated!!!!!", Toast.LENGTH_LONG).show();

                        }
                    }
                }
            });

    }
}