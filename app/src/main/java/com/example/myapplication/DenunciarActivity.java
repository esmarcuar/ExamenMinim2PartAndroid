package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

public class DenunciarActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_denunciar);
    }

    public void buttonCancel(android.view.View v) {
        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
    }
}