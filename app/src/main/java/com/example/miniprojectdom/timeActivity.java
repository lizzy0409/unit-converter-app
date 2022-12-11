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

public class timeActivity extends AppCompatActivity {


    Spinner convertFromSpinner;
    Spinner convertToSpinner;
    EditText inputEditText;
    Button btnSave;
    TextView resultTextView;
    private static final String[] uniteDistance = {"sec", "min", "H"};
    private static final List<String> uniteDistanceList = Arrays.asList(uniteDistance);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_time);

        getSupportActionBar().setTitle("Time Converter");

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

               if(convertFromUnit == "H" && convertToUnite == "min") result = input * 60;
               else if(convertFromUnit == "H" && convertToUnite == "sec") result = input * 3600;
               else if(convertFromUnit == "min" && convertToUnite == "sec") result = input * 60;
               else if(convertFromUnit == "sec" && convertToUnite == "min") result = input / 60;
               else if(convertFromUnit == "min" && convertToUnite == "H") result = input / 60;

                result =Double.parseDouble(new DecimalFormat("##.##").format(result));

                resultTextView.setText(resultMessage + result.toString() + " " + convertToUnite);
            }
        });
    }
}