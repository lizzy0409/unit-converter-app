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

<<<<<<< HEAD
=======

>>>>>>> 79f61780e94281c45d1ce32e32c2f9411a470d94

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.HashMap;

public class energyActivity extends AppCompatActivity {
    Spinner spinner1;
    Spinner spinner2;
    EditText editText;
    Button btnSave;
    TextView result;
    String[] unitEnergy = {"J","KJ","KWh","Kcal","Kpm"};
    HashMap<String, BigDecimal> map = new HashMap<String, BigDecimal>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_energy);

        getSupportActionBar().setTitle("Energy Converter");


        editText = findViewById(R.id.editEnergy);
        spinner1 = findViewById(R.id.spFromEnergy);
        spinner2 = findViewById(R.id.spToEnergy);
        result = findViewById(R.id.stText);
        btnSave = findViewById(R.id.btnSaveEnergy);

        map.put("J/J", new BigDecimal(1.0));
        map.put("J/KJ", new BigDecimal(0.0001));
        map.put("J/KWh", new BigDecimal(0.000000278));
        map.put("J/Kcal", new BigDecimal(0.000239));
        map.put("J/Kpm", new BigDecimal(0.102));

        map.put("kJ/J", new BigDecimal(1000.0));
        map.put("KJ/KJ", new BigDecimal(1.0));
        map.put("KJ/KWh", new BigDecimal(0.000278));
        map.put("KJ/Kcal", new BigDecimal(0.239));
        map.put("KJ/Kpm", new BigDecimal(102.0));

        map.put("KWh/J", new BigDecimal(3600000));
        map.put("KWh/KJ", new BigDecimal(3600));
        map.put("KWh/KWh", new BigDecimal(1.0));
        map.put("KWh/Kcal", new BigDecimal(860.0));
        map.put("KWh/Kpm", new BigDecimal(367000));

        map.put("Kcal/J", new BigDecimal(4190));
        map.put("Kcal/KJ", new BigDecimal(4.19));
        map.put("Kcal/KWh", new BigDecimal(0.000116));
        map.put("Kcal/Kcal", new BigDecimal(1.0));
        map.put("Kcal/Kpm", new BigDecimal(427.0));

        map.put("Kpm/J", new BigDecimal(9.81));
        map.put("Kpm/KJ", new BigDecimal(0.000982) );
        map.put("Kpm/KWh",new BigDecimal(0.00000272));
        map.put("Kpm/Kcal", new BigDecimal(0.00234));
        map.put("Kpm/Kpm", new BigDecimal(1.0));


        ArrayAdapter ad =  new ArrayAdapter<String>(this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item,unitEnergy);
        spinner1.setAdapter(ad);

        ArrayAdapter ad2 =  new ArrayAdapter<String>(this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item,unitEnergy);
        spinner2.setAdapter(ad2);

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                  Double amount = Double.parseDouble(editText.getText().toString());
                  Double totale = map.get(spinner1.getSelectedItem().toString()+"/"+ spinner2.getSelectedItem().toString()).doubleValue() * amount;
                  totale = Double.parseDouble(new DecimalFormat("#########.###############").format(totale));
                  result.setText("The result is: " + totale.toString() + " " + spinner2.getSelectedItem().toString());
                  editText.setText("");
            }
        });
    }
}
