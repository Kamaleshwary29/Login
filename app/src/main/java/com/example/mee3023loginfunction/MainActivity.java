package com.example.mee3023loginfunction;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText editTextTextEmailAddress, editTextTextPassword, editTextTextConfirmPassword;
    Button buttonSignin, buttonSignup;
    DBHelper DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextTextEmailAddress = (EditText) findViewById(R.id.editTextTextEmailAddress);
        editTextTextPassword = (EditText) findViewById(R.id.editTextTextPassword);
        editTextTextConfirmPassword = (EditText) findViewById(R.id.editTextTextConfirmPassword);
        buttonSignin = (Button) findViewById(R.id.buttonSignin);
        buttonSignup = (Button) findViewById(R.id.buttonSignup);
        DB = new DBHelper(this);

        buttonSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user = editTextTextEmailAddress.getText().toString();
                String pass = editTextTextPassword.getText().toString();
                String confirmpassword = editTextTextConfirmPassword.getText().toString();

                if(user.equals("") || pass.equals("") || confirmpassword.equals(""))
                    Toast.makeText(MainActivity.this,"Register New Account", Toast.LENGTH_SHORT).show();
                else
                    if(pass.equals(confirmpassword)){
                        Boolean checkuser = DB.checkeditTextTextEmailAddress(user);
                        if(checkuser == false){
                            Boolean insert = DB.insertData(user, pass);
                            if(insert = true){
                                Toast.makeText(MainActivity.this, "Registration Successful", Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent (getApplicationContext(), HomeActivity.class);
                                startActivity(intent);
                            }
                            else{
                                Toast.makeText(MainActivity.this, "Registration Unsuccessful", Toast.LENGTH_SHORT).show();
                            }
                        }
                        else{
                            Toast.makeText(MainActivity.this, "User Already Exist. Sign In", Toast.LENGTH_SHORT).show();
                        }
                    }
                    else{
                        Toast.makeText(MainActivity.this, "Incorrect Password", Toast.LENGTH_SHORT).show();
                    }


            }
        });

        buttonSignin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
                startActivity(intent);

            }
        });




    }
}