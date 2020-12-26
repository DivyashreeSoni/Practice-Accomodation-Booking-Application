package com.example.divyashreesoni.practice;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;


public class Main6Activity extends AppCompatActivity {

    Button A;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main6);

        A = (Button) findViewById(R.id.button1);

        A.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Main6Activity.this, Main7Activity.class);
                startActivity(i);
            }
        });

    }
}
