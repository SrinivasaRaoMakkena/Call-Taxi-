package com.nwmissouri.taxiapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.parse.LogInCallback;
import com.parse.ParseException;
import com.parse.ParseUser;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    EditText username,password ;
    Button login,register;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        username = (EditText)findViewById(R.id.uName);
        password = (EditText)findViewById(R.id.uPass);
        login = (Button)findViewById(R.id.loginBtn);
        register = (Button)findViewById(R.id.RegisterBtn);

        register.setOnClickListener(this);
        login.setOnClickListener(this);



    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.RegisterBtn){
            Intent intent = new Intent(getApplicationContext(),RegistrationActivity.class);
            startActivity(intent);
        }else if (view.getId() == R.id.loginBtn){
            ParseUser.logInInBackground(username.getText().toString(), password.getText().toString(), new LogInCallback() {
                @Override
                public void done(ParseUser parseUser, ParseException e) {
                    if (e==null && !parseUser.getUsername().isEmpty()){

                        Intent intent = new Intent(getApplicationContext(),HomeActivity.class);
                        startActivity(intent);

                        Toast.makeText(getApplicationContext(),"Login-success",Toast.LENGTH_SHORT).show();
                    }else{
                        Toast.makeText(getApplicationContext(),"Login-Failed",Toast.LENGTH_SHORT).show();
                        Log.i("Login-Error", e.getMessage());
                    }
                }
            });
        }
    }
}
