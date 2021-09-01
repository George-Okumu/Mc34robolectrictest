package com.moringa.mc34robolectrictest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private Button registerActivityButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        registerActivityButton = findViewById(R.id.secondActivityButton);
        registerActivityButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v == registerActivityButton){
            Intent registerActivityIntent = new Intent(MainActivity.this, RegisterActivity.class);
            startActivity(registerActivityIntent);
        }
    }
}