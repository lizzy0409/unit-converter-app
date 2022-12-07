package com.example.miniprojectdom;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.HashMap;

public class speedActivity extends AppCompatActivity {
    Spinner spinner1;
    Spinner spinner2;
    EditText editText;
    Button btnSave;
    TextView result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_speed);

        getSupportActionBar().setTitle("Speed Converter");


        editText = findViewById(R.id.editSpeed);
        spinner1 = findViewById(R.id.spFromSpeed);
        spinner2 = findViewById(R.id.spToSpeed);
        result = findViewById(R.id.stText);
        btnSave = findViewById(R.id.btnSaveEnergy);


        HashMap<String, BigDecimal> map = new HashMap<String, BigDecimal>();
        map.put("m/s/m/s", new BigDecimal(1.0));
        map.put("m/s/Km/h", new BigDecimal(3.6));
        map.put("m/s/ft/s", new BigDecimal(3.281));


        map.put("Km/h/m/s", new BigDecimal(0.278));
        map.put("Km/h/Km/h", new BigDecimal(1.0));
        map.put("Km/h/ft/s", new BigDecimal(0.91));


        map.put("ft/s/m/s", new BigDecimal(0.305));
        map.put("ft/s/Km/h", new BigDecimal(1.09));
        map.put("ft/s/ft/s", new BigDecimal(1.0));


        String[] from = {"m/s","Km/h","ft/s"};
        ArrayAdapter ad =  new ArrayAdapter<String>(this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item,from);
        spinner1.setAdapter(ad);
        String[] to = {"m/s","Km/h","ft/s"};
        ArrayAdapter ad2 =  new ArrayAdapter<String>(this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item,to);
        spinner2.setAdapter(ad2);

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
// //               String amountS = editText.getText().toString()
//                if(amountS == ""){
//                    Toast.makeText(getApplicationContext(),"enter a number in the amount",Toast.LENGTH_SHORT).show();
//                }
//                else {
                Double amount = Double.parseDouble(editText.getText().toString());
//                }
                String units = spinner1.getSelectedItem().toString()+"/"+ spinner2.getSelectedItem().toString();

                Double totale = map.get(units).doubleValue() * amount;
                totale = Double.parseDouble(new DecimalFormat("#########.#####").format(totale));
                result.setText("The result is: " + totale.toString() + " " + spinner2.getSelectedItem().toString());
                editText.setText("");
            }
        });
    }
    }
