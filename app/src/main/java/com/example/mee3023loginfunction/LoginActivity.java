package com.example.mee3023loginfunction;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {


    EditText editTextTextEmailAddress, editTextTextPassword;
    Button buttonSignin;
    DBHelper DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        editTextTextEmailAddress = (EditText) findViewById(R.id.editTextTextEmailAddress1);
        editTextTextPassword = (EditText) findViewById(R.id.editTextTextPassword1);
        buttonSignin = (Button) findViewById(R.id.buttonSignin1);
        DB = new DBHelper(this);

        buttonSignin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String user = editTextTextEmailAddress.getText().toString();
                String pass = editTextTextPassword.getText().toString();

                if(user.equals("") || pass.equals(""))
                    Toast.makeText(LoginActivity.this, "Please Enter the Details", Toast.LENGTH_SHORT).show();
                else{
                    Boolean checkuserpass = DB.checkeditTextTextEmailAddressEditTextTextPassword(user, pass);
                    if(checkuserpass == true){
                        Toast.makeText(LoginActivity.this, "Sign In Successful", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(getApplicationContext(), HomeActivity.class);
                        startActivity(intent);
                    }
                    else{
                        Toast.makeText(LoginActivity.this, "Invalid Username or Password", Toast.LENGTH_SHORT).show();
                    }
                }


            }
        });

    }
}