package com.example.ibra.parsetutorials;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class Register extends AppCompatActivity {
    protected  EditText mUserName;
    protected  EditText mUserEmail;
    protected  EditText mUserPassword;
    protected Button mbutton;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        mUserName =    (EditText) findViewById(R.id.RegisterUsernameEditText);
        mUserEmail =   (EditText) findViewById(R.id.RegisterEmailEditText);
        mUserPassword =(EditText) findViewById(R.id.RegisterPasswordEditText);
        mbutton = (Button) findViewById(R.id.SignUpButton);


    }
}
