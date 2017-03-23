package com.nwmissouri.taxiapp;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.parse.ParseException;
import com.parse.ParseUser;
import com.parse.SignUpCallback;

public class RegistrationActivity extends AppCompatActivity {
    EditText uFName,uLName,uPass,uCPass,uEmail;
    Button submit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        setTitle("Registration");

        uFName = (EditText) findViewById(R.id.firstName);
        uLName = (EditText) findViewById(R.id.lastName);
        uPass = (EditText) findViewById(R.id.password);
        uCPass = (EditText) findViewById(R.id.confirmPassword);
        uEmail = (EditText) findViewById(R.id.email);

        submit = (Button) findViewById(R.id.RegBTN);


submit.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        ParseUser parseUser = new ParseUser();
        parseUser.put("firstName",uFName.getText().toString());
        parseUser.put("lastName",uLName.getText().toString());
        parseUser.put("confirmPassword",uCPass.getText().toString());

        parseUser.setUsername(uEmail.getText().toString());
        parseUser.setPassword(uPass.getText().toString());
        parseUser.setEmail(uEmail.getText().toString());

        parseUser.signUpInBackground(new SignUpCallback() {
            @Override
            public void done(ParseException e) {
                if (e == null){
                    Toast.makeText(getApplicationContext(),"User Saved",Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(getApplicationContext(),"Reg Failed",Toast.LENGTH_SHORT).show();
                    Log.i("Info",e.getMessage());
                }
            }
        });


    }
});

    }
}
