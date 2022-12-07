package com.example.miniprojectdom;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class massActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mass);

        getSupportActionBar().setTitle("Mass Converter");
    }
}