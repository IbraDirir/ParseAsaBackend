package com.example.ibra.parsetutorials;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.parse.LogInCallback;
import com.parse.ParseUser;

import java.text.ParseException;

public class LoginActivity extends Activity {
    private EditText mUserame;
    private EditText mPassword;
    private Button mLogin;
    private TextView or;
    private Button mSignUp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

     mUserame = (EditText) findViewById(R.id.LoginEditText);
     mPassword = (EditText) findViewById(R.id.passwordEditText);
     mLogin = (Button) findViewById(R.id.LoginButtton);
        or = (TextView) findViewById(R.id.textViewOr);
    mSignUp = (Button) findViewById(R.id.SignUpButton);


        mSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //take user to Register Activity
                Intent intent = new Intent(LoginActivity.this,Register.class);
                startActivity(intent);
            }
        });

        mLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //get user inputs from editText and convert it to strings
                String username  = mUserame.getText().toString().trim();
                String password = mPassword.getText().toString().trim();




                ParseUser.logInInBackground(username,  password , new LogInCallback() {
                    @Override
                    public void done(ParseUser user, com.parse.ParseException e) {

                     if(e == null){
                         //user is logged in
                         Toast.makeText(LoginActivity.this,"welcome again", Toast.LENGTH_LONG).show();

                         Intent i = new Intent(LoginActivity.this,MainActivity.class);
                         startActivity(i);
                     }else{
                         //sign Up failed
                         final AlertDialog.Builder builder =  new AlertDialog.Builder(LoginActivity.this);
                         builder.setMessage(e.getMessage());
                         builder.setTitle("sorry!");
                         builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                             @Override
                             public void onClick(DialogInterface dialog, int which) {

                                 dialog.dismiss();
                             }



                         });

                         AlertDialog dialog = builder.create();
                         dialog.show();

                     }


                    }
                });
            }
        });


    }


}
