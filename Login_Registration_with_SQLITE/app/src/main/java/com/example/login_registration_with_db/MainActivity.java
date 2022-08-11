package com.example.login_registration_with_db;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.mobsandgeeks.saripaar.ValidationError;
import com.mobsandgeeks.saripaar.Validator;
import com.mobsandgeeks.saripaar.annotation.ConfirmPassword;
import com.mobsandgeeks.saripaar.annotation.Email;
import com.mobsandgeeks.saripaar.annotation.Length;
import com.mobsandgeeks.saripaar.annotation.NotEmpty;
import com.mobsandgeeks.saripaar.annotation.Password;
import com.mobsandgeeks.saripaar.annotation.Pattern;

import java.util.List;

public class MainActivity extends AppCompatActivity implements Validator.ValidationListener {
   @NotEmpty
   @Length(min = 3, max = 10)
    private EditText et_username;
    @NotEmpty
    @Email
    private EditText et_email;
    @NotEmpty
    @Password
    private EditText et_password;
    @ConfirmPassword
    private EditText et_cpassword;
    private Validator validator;

    Button btn_register, btn_login;
    dbhelper databaseHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        validator = new Validator(this);
        validator.setValidationListener(this);

        databaseHelper = new dbhelper(this);
        et_username = (EditText)findViewById(R.id.et_username);
        et_email = (EditText)findViewById(R.id.email);
        et_password = (EditText)findViewById(R.id.et_password);
        et_cpassword = (EditText)findViewById(R.id.et_cpassword);
        btn_register = (Button)findViewById(R.id.btn_register);
        btn_login = (Button)findViewById(R.id.btn_login);

        btn_login.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Login.class);
                startActivity(intent);
            }
        });

        btn_register.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                validator.validate();

            }
        });
    }

    @Override
    public void onValidationSucceeded() {
        String email = et_email.getText().toString();
        String username = et_username.getText().toString();
        String password = et_password.getText().toString();
        String confirm_password = et_cpassword.getText().toString();

        /*if(username.equals("") || password.equals("") || confirm_password.equals("")||email.equals(""))
        {
            Toast.makeText(getApplicationContext(), "Fields Required", Toast.LENGTH_SHORT).show();
        }
        else
        {}*/
            if(password.equals(confirm_password))
            {
                Boolean checkusername = databaseHelper.CheckUsername(username);
                if(checkusername == true){
                    Boolean insert = databaseHelper.Insert(username, password,email);
                    if(insert == true){
                        Toast.makeText(getApplicationContext(), "Registered", Toast.LENGTH_SHORT).show();
                        et_username.setText("");
                        et_password.setText("");
                        et_cpassword.setText("");
                        et_email.setText("");
                    }
                }
                else
                {
                    Toast.makeText(getApplicationContext(), "Username already taken", Toast.LENGTH_SHORT).show();
                }
            }
            else
            {
                Toast.makeText(getApplicationContext(), "Password does not match", Toast.LENGTH_SHORT).show();
            }

    }

    @Override
    public void onValidationFailed(List<ValidationError> errors) {
        for (ValidationError error : errors) {
            View view = error.getView();
            String message = error.getCollatedErrorMessage(this);
            // Display error messages
            if (view instanceof EditText) {
                ((EditText) view).setError(message);
            } else {
                Toast.makeText(this, message, Toast.LENGTH_LONG).show();
            }
        }

    }
}