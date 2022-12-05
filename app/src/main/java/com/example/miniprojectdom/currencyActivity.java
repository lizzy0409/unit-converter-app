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

public class currencyActivity extends AppCompatActivity {
    Spinner sp1;
    Spinner sp2;
    EditText ed1;
    Button btnSave;
    TextView result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_currency);
        ed1 = findViewById(R.id.edttext);
        sp1 = findViewById(R.id.spFrom);
        sp2 = findViewById(R.id.spTo);
        btnSave = findViewById(R.id.btnSave);
        result = findViewById(R.id.stText);

        String[] from = {"USD"};
        ArrayAdapter ad =  new ArrayAdapter<String>(this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item,from);
        sp1.setAdapter(ad);
        String[] to = {"DH","$"};
        ArrayAdapter ad2 =  new ArrayAdapter<String>(this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item,to);
        sp2.setAdapter(ad2);

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Double tot;
                Double amount = Double.parseDouble(ed1.getText().toString());
                if(sp1.getSelectedItem().toString() == "USD" && sp2.getSelectedItem().toString() == "DH"){
                    tot = amount * 10;
                    result.setText("The result is: " + amount + " " + sp2.getSelectedItem().toString());
                   
                }
            }
        });
    }
}