package com.example.miniprojectdom;

import static java.lang.Math.pow;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.HashMap;

public class powerActivity extends AppCompatActivity {
    Spinner spinner1;
    Spinner spinner2;
    EditText editText;
    Button btnSave;
    TextView result;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_power);

        getSupportActionBar().setTitle("Power Converter");

            editText = findViewById(R.id.editPower);
            spinner1 = findViewById(R.id.spFromPower);
            spinner2 = findViewById(R.id.spToPower);
            btnSave = findViewById(R.id.btnSavePower);
            result = findViewById(R.id.stText);

            String[] units = {"pW","nW","uW","mW","W","KW","MW","GW","TW"};

            String[] from = {"pW","nW","uW","mW","W","KW","MW","GW","TW"};
            ArrayAdapter ad =  new ArrayAdapter(this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item,from);
            spinner1.setAdapter(ad);

            String[] to = {"pW","nW","uW","mW","W","KW","MW","GW","TW"};
            ArrayAdapter ad2 =  new ArrayAdapter(this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item,to);
            spinner2.setAdapter(ad2);

            btnSave.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Double totale;
                    Double amount = Double.parseDouble(editText.getText().toString());
                    String unit1 = spinner1.getSelectedItem().toString();
                    String unit2 = spinner2.getSelectedItem().toString();
                    int a = 0;
                    int b = 0;

                    for(int i = 0; i<units.length;i++){
                        if(units[i] == unit1)
                            a = i;
                        if(units[i] == unit2)
                            b = i;
                    }
                    totale = amount * pow(10,(a-b)*3);
                    result.setText("The result is: " + totale + " " + spinner2.getSelectedItem().toString());
                    editText.setText("");
                }
            });
        }

    }
