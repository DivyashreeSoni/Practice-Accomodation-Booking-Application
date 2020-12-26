package com.example.divyashreesoni.practice;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

public class Main7Activity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    String[] month = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12"};
    String[] year = {"2020", "2021", "2022", "2023", "2024", "2025", "2026", "2027", "2028", "2029"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main7);

        Spinner s = (Spinner) findViewById(R.id.spinner2);
        s.setOnItemSelectedListener(this);
        Spinner S = (Spinner) findViewById(R.id.spinner3);
        S.setOnItemSelectedListener(this);

        ArrayAdapter a = new ArrayAdapter(this, android.R.layout.simple_spinner_item, month);
        a.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        s.setAdapter(a);

        ArrayAdapter b = new ArrayAdapter(this, android.R.layout.simple_spinner_item, year);
        b.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        S.setAdapter(b);
    }

    @Override
    public void onItemSelected(AdapterView<?> arg0, View arg1, int position, long id) {
        Toast.makeText(getApplicationContext(), month[position], Toast.LENGTH_LONG).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> arg0) {

    }
}
