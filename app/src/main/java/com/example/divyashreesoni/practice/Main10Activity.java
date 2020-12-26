package com.example.divyashreesoni.practice;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Main10Activity extends AppCompatActivity {
    Button A;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main10);

        A = (Button) findViewById(R.id.b1);

        A.setOnClickListener(new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Main10Activity.this,Main7Activity.class);
                startActivity(i);
            }
        });
    }
}
