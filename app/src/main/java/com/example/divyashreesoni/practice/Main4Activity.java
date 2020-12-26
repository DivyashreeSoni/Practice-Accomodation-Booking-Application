package com.example.divyashreesoni.practice;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Main4Activity extends AppCompatActivity {

    Button A,B,C,D,E,F,G;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);

        A = (Button) findViewById(R.id.b1);
        B = (Button) findViewById(R.id.b2);
        C = (Button) findViewById(R.id.b3);
        D = (Button) findViewById(R.id.b4);
        E = (Button) findViewById(R.id.b5);
        F = (Button) findViewById(R.id.b6);
        G = (Button) findViewById(R.id.b7);

        A.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Main4Activity.this,Main10Activity.class);
                startActivity(i);
            }
        });
       C.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Intent i = new Intent(Main4Activity.this,Main11Activity.class);
               startActivity(i);
           }
       });
       F.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Intent i = new Intent(Main4Activity.this,Main12Activity.class);
               startActivity(i);
           }
       });
    }
}
