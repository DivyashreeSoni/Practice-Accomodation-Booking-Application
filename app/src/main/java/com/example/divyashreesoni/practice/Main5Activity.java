package com.example.divyashreesoni.practice;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Main5Activity extends AppCompatActivity {
    Button A,B,C,D,E,F,G,H,I;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);
        A = (Button) findViewById(R.id.button1);
        B = (Button) findViewById(R.id.button2);
        C = (Button) findViewById(R.id.button3);
        D = (Button) findViewById(R.id.button4);
        E = (Button) findViewById(R.id.button5);
        F = (Button) findViewById(R.id.button6);
        G = (Button) findViewById(R.id.button7);
        H = (Button) findViewById(R.id.button8);
        I = (Button) findViewById(R.id.b9);

        A.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Main5Activity.this,Main6Activity.class);
                startActivity(i);
            }
        });
        B.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Main5Activity.this,Main8Activity.class);
                startActivity(i);
            }
        });
    }
}
