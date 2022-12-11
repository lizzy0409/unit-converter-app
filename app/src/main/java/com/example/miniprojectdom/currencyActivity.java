package com.example.miniprojectdom;

    import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.HashMap;

public class currencyActivity extends AppCompatActivity {
    Spinner spinner1;
    Spinner spinner2;
    EditText editText;
    Button btnSave;
    TextView result;
    String[] unitCurrency = {"USD","DH","$"};
    String[] to = {"DH","$","USD"};
    HashMap<String, Double> map = new HashMap<String, Double>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_currency);

       editText = findViewById(R.id.editCurrency);
       spinner1 = findViewById(R.id.spFromCurrency);
       spinner2 = findViewById(R.id.spToCurrency);
        btnSave = findViewById(R.id.btnSaveCurrency);
        result = findViewById(R.id.stText);


        map.put("USD/DH", 10.53);
        map.put("$/DH", 11.05);
        map.put("$/USD", 1.05);
        map.put("DH/USD", 0.095);
        map.put("DH/$", 0.091);
        map.put("USD/$", 0.95);


        ArrayAdapter ad =  new ArrayAdapter<String>(this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item,unitCurrency)                ;
        spinner1.setAdapter(ad);

        ArrayAdapter ad2 =  new ArrayAdapter<String>(this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item,unitCurrency);
        spinner2.setAdapter(ad2);

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Double totale;
                Double amount = Double.parseDouble(editText.getText().toString());
                totale = map.get(spinner1.getSelectedItem().toString()+"/"+ spinner2.getSelectedItem().toString()) * amount;
                result.setText("The result is: " + totale + " " + spinner2.getSelectedItem().toString());
                editText.setText("");

            }
        });
    }
}