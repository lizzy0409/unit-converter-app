package com.example.miniprojectdom;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.List;

public class temperatureActivity extends AppCompatActivity {

    Spinner convertFromSpinner;
    Spinner convertToSpinner;
    EditText inputEditText;
    Button btnSave;
    TextView resultTextView;
    private static final String[] uniteDistance = {"°C", "°F", "K"};
    private static final List<String> uniteDistanceList = Arrays.asList(uniteDistance);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_temperature);

        getSupportActionBar().setTitle("Temperature Converter");


        convertFromSpinner = (Spinner) findViewById(R.id.spFrom);
        convertToSpinner = (Spinner) findViewById(R.id.spTo);
        inputEditText = (EditText) findViewById(R.id.edttext);
        btnSave = (Button) findViewById(R.id.btnSave);
        resultTextView = (TextView) findViewById(R.id.resultText);

        ArrayAdapter fromConvertAdapter = new ArrayAdapter<String>(this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item,uniteDistance);
        convertFromSpinner.setAdapter(fromConvertAdapter);
        convertToSpinner.setAdapter(fromConvertAdapter);

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String resultMessage = "the result is :";
                Double result = 0.0;
                Double input = Double.parseDouble(inputEditText.getText().toString());
                String convertFromUnit = convertFromSpinner.getSelectedItem().toString();
                String convertToUnite  = convertToSpinner.getSelectedItem().toString();

                if(convertFromUnit == "°C" && convertToUnite == "°F") result = input * 9/5 + 32;
                else if(convertFromUnit == "°C" && convertToUnite == "K") result = input + 273.15;
                else if(convertFromUnit == "°F" && convertToUnite == "°C") result = (input - 32) * 5/9;
                else if(convertFromUnit == "K" && convertToUnite == "°C") result = input - 273.15;
                else if(convertFromUnit == "K" && convertToUnite == "°F") result = (input - 273.15) * 9/5 +32;
                else if(convertFromUnit == "°F" && convertToUnite == "K") result = (input - 32) * 5/9 + 273.15;


                result =Double.parseDouble(new DecimalFormat("##.##").format(result));

                resultTextView.setText(resultMessage + result.toString() + " " + convertToUnite);
            }
        });
    }
}