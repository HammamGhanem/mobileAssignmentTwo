package com.example.secondass;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Second_Activity extends AppCompatActivity {
    Button firstButton , secondButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        firstButton = findViewById(R.id.buttonpageOne);
        secondButton = findViewById(R.id.buttonPageTwo);

        firstButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Second_Activity.this , Third_Activity.class);
                startActivity(intent);
                Toast.makeText(getApplicationContext(),"online game page ",Toast.LENGTH_LONG).show();

            }
        });
        secondButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Second_Activity.this , Forth_Activity.class);
                startActivity(intent);
                Toast.makeText(getApplicationContext(),"Power game page ",Toast.LENGTH_LONG).show();

            }
        });
    }
}