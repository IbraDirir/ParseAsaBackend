package com.example.ibra.parsetutorials;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.parse.Parse;
import com.parse.ParseException;
import com.parse.ParseUser;
import com.parse.SignUpCallback;

public class Register extends AppCompatActivity {
    protected  EditText mUserName;
    protected  EditText mUserEmail;
    protected  EditText mUserPassword;
    protected Button mbutton;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

//initialize



        mUserName =    (EditText) findViewById(R.id.RegisterUsernameEditText);
        mUserEmail =   (EditText) findViewById(R.id.RegisterEmailEditText);
        mUserPassword =(EditText) findViewById(R.id.RegisterPasswordEditText);
        mbutton = (Button) findViewById(R.id.SignUpButton);

        //Listen to button clicks

        mbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                //get username, password and email convert them into string

                String username = mUserName.getText().toString().trim();
                String password = mUserPassword.getText().toString().trim();
                String email = mUserEmail.getText().toString().trim();




               //store user in parse
                ParseUser user = new ParseUser();
                user.setUsername(username);
                user.setPassword(password);
                user.setEmail(email);

                user.signUpInBackground(new SignUpCallback() {
                    @Override
                    public void done(ParseException e) {

                        if (e == null){
                            //user signed up succesfully
                            Toast.makeText(Register.this, R.string.welcome_message, Toast.LENGTH_LONG).show();

                            Intent intent = new Intent(Register.this,MainActivity.class);
                            startActivity(intent);

                        }else{
                            //there was an error. advice user
                        }




                    }
                });


            }
        });

    }
}
