package com.example.mope.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private static EditText username;
    private static EditText password;
    private static TextView attempts;
    private static Button loginButton;
    int attempts_counter = 5;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        loginButton();
    }

    public void loginButton(){
        username = (EditText) findViewById(R.id.loginNameTxt);
        password = (EditText) findViewById(R.id.passwordTxt);
        attempts = (EditText) findViewById(R.id.attemptsTxt);
        loginButton = (Button) findViewById(R.id.loginButton);

        attempts.setText(Integer.toString(attempts_counter));

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (username.getText().toString().equals("user")){
                    if (password.getText().toString().equals("123qwe")){
                        Toast.makeText(MainActivity.this,"User and Password Correct",Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent("com.example.mope.myapplication.User");
                        startActivity(intent);
                    }
                }else{
                    Toast.makeText(MainActivity.this,"User and Password are not Correct!!, please try again",Toast.LENGTH_SHORT).show();
                    attempts_counter--;
                    attempts.setText(Integer.toString(attempts_counter));
                    if (attempts_counter >= 0){
                        loginButton.setEnabled(false);
                    }
                }

            }
        });
    }
}
