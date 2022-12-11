package com.example.miniprojectdom;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    CardView distanceCardView;
    CardView areaCardView;
    CardView volumeCardView;
    CardView weightCardView;
    CardView timeCardView;
    CardView temperatureCardView;
    CardView powerCardView;
    CardView speedCardView;
    CardView energyCardView;
    CardView massCardView;
    CardView pressureCardView;
    CardView currencyCardView;

    Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().setTitle("Unit Converter");

        distanceCardView = (CardView) findViewById(R.id.distanceCardView);
        areaCardView = (CardView) findViewById(R.id.areaCardView);
        volumeCardView = (CardView) findViewById(R.id.volumeCardView);
        weightCardView = (CardView) findViewById(R.id.wightCardView);
        timeCardView = (CardView) findViewById(R.id.timeCardView);
        temperatureCardView = (CardView) findViewById(R.id.temperatureCardView);
        powerCardView = (CardView) findViewById(R.id.powerCardView);
        speedCardView = (CardView) findViewById(R.id.speedCardView);
        energyCardView = (CardView) findViewById(R.id.energyCardView);
        massCardView = (CardView) findViewById(R.id.massCardView);
        pressureCardView = (CardView) findViewById(R.id.pressureCardView);
        currencyCardView = (CardView) findViewById(R.id.curencyCardView);


        distanceCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent = new Intent(MainActivity.this, distanceActivity.class);
                startActivity(intent);
            }
        });

        areaCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent = new Intent(MainActivity.this, areaActivity.class);
                startActivity(intent);
            }
        });

        volumeCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent = new Intent(MainActivity.this, volumeActivity.class);
                startActivity(intent);
            }
        });

        weightCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent = new Intent(MainActivity.this, wieghtActivity.class);
                startActivity(intent);
            }
        });

        timeCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent = new Intent(MainActivity.this, timeActivity.class);
                startActivity(intent);
            }
        });

        temperatureCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent = new Intent(MainActivity.this, temperatureActivity.class);
                startActivity(intent);
            }
        });


        powerCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent = new Intent(MainActivity.this, powerActivity.class);
                startActivity(intent);
            }
        });

        speedCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent = new Intent(MainActivity.this, speedActivity.class);
                startActivity(intent);
            }
        });

        energyCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent = new Intent(MainActivity.this, energyActivity.class);
                startActivity(intent);
            }
        });

        massCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent = new Intent(MainActivity.this, massActivity.class);
                startActivity(intent);
            }
        });

        pressureCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent = new Intent(MainActivity.this, pressureActivity.class);
                startActivity(intent);
            }
        });

        currencyCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent = new Intent(MainActivity.this, currencyActivity.class);
                startActivity(intent);
            }
        });

    }


}