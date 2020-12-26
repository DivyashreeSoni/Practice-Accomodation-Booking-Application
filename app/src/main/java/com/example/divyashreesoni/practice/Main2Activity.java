package com.example.divyashreesoni.practice;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Main2Activity extends AppCompatActivity {
    Button HOTEL,RESORT,TREEHOUSE,FARMHOUSE,PALACE,HOME;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        HOTEL = (Button) findViewById(R.id.button2);
        RESORT = (Button) findViewById(R.id.button3);
        TREEHOUSE = (Button) findViewById(R.id.button4);
        FARMHOUSE = (Button) findViewById(R.id.button5);
        PALACE = (Button) findViewById(R.id.button6);
        HOME = (Button) findViewById(R.id.button7);

        HOTEL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Main2Activity.this, Main3Activity.class);
                startActivity(i);
            }
            });
                TREEHOUSE.setOnClickListener(new View.OnClickListener(){
                    @Override
                    public void onClick(View v) {
                        Intent i = new Intent(Main2Activity.this,Main5Activity.class);
                        startActivity(i);
                    }
        });
                PALACE.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent i = new Intent(Main2Activity.this,Main4Activity.class);
                        startActivity(i);
                    }
                });
                RESORT.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent i = new Intent(Main2Activity.this,Main9Activity.class);
                        startActivity(i);
                    }
                });
            }
}
