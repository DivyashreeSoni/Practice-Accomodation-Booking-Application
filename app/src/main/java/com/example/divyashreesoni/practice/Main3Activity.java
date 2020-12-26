package com.example.divyashreesoni.practice;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

public class Main3Activity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    String[] CityNames={"Select","A","B"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        Spinner spin = (Spinner) findViewById(R.id.spinner);
        spin.setOnItemSelectedListener(this);
        ArrayAdapter a = new ArrayAdapter(this, android.R.layout.simple_spinner_item, CityNames);
        a.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spin.setAdapter(a);
    }
         @Override
            public void onItemSelected(AdapterView<?> arg0,View arg1,int position,long id) {
        if (CityNames.equals("A")) {
            Intent i = new Intent(Main3Activity.this, Main4Activity.class);
            startActivity(i);
        }

         }

         @Override
            public void onNothingSelected(AdapterView<?> arg0) {

         }
        }




