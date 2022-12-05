package com.example.miniprojectdom;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class distanceActivity extends AppCompatActivity {
    private Spinner spinner;
    private static final String[] uniteDistance = {"mm", "dm", "cm", "m", "dam", "Km"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_distance);
    }
}