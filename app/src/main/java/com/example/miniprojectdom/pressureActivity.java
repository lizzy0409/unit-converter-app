package com.example.miniprojectdom;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.HashMap;

public class pressureActivity extends AppCompatActivity {
    Spinner spinner1;
    Spinner spinner2;
    EditText editText;
    Button btnSave;
    TextView result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pressure);

        editText = findViewById(R.id.editPressure);
        spinner1 = findViewById(R.id.spFromPressure);
        spinner2 = findViewById(R.id.spToPressure);
        result = findViewById(R.id.stText);
        btnSave = findViewById(R.id.btnSaveEnergy);


        HashMap<String, BigDecimal> map = new HashMap<String, BigDecimal>();
        map.put("Pa/Pa", new BigDecimal(1.0));
        map.put("Pa/bar", new BigDecimal(0.00001));
        map.put("Pa/atm", new BigDecimal(0.00000987));


        map.put("bar/Pa", new BigDecimal(100000));
        map.put("bar/bar", new BigDecimal(1.0));
        map.put("bar/atm", new BigDecimal(0.98692));


        map.put("atm/Pa", new BigDecimal(101325));
        map.put("atm/bar", new BigDecimal(0.980665));
        map.put("atm/atm", new BigDecimal(0.967841));


        String[] from = {"Pa","bar","atm"};
        ArrayAdapter ad =  new ArrayAdapter<String>(this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item,from);
        spinner1.setAdapter(ad);
        String[] to = {"Pa","bar","atm"};
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
                totale = Double.parseDouble(new DecimalFormat("#########.############").format(totale));
                result.setText("The result is: " + totale.toString() + " " + spinner2.getSelectedItem().toString());
                editText.setText("");
            }
        });
    }
}

