package com.example.secondass;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText userName , password;
    Button logIn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        userName = findViewById(R.id.userName);
        password = findViewById(R.id.password);
        logIn = findViewById(R.id.buttonLogIn);

        userName.getText();
        password.getText();

        logIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String correctuser = "admin";
                String correctpass = "admin";
                if (userName.getText().toString().equals(correctuser) && password.getText().toString().equals(correctpass)){
                    Intent intent = new Intent(MainActivity.this , Second_Activity.class);
                    startActivity(intent);
                    Toast.makeText(getApplicationContext(),"Login successfully ",Toast.LENGTH_LONG).show();
                }else {
                    Toast.makeText(getApplicationContext(),"Login Failed ",Toast.LENGTH_LONG).show();
                }

            }
        });


    }
}