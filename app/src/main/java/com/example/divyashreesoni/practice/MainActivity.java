package com.example.divyashreesoni.practice;

import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.BaseColumns;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.HashMap;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    Button Submit;
    private Retrofit retrofit;
    private RetrofitInterface retrofitInterface;
    private String BASE_URL="http:// 192.168.43.152:3000";

    EditText Name, Password, Email, Contact;
    DatabaseHelper myDb;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        retrofit=new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        retrofitInterface=retrofit.create(RetrofitInterface.class);
        myDb = new DatabaseHelper(this);
        Name = (EditText) findViewById(R.id.editText);
        Password = (EditText) findViewById(R.id.editText2);
        Email = (EditText) findViewById(R.id.editText3);
        Contact = (EditText) findViewById(R.id.editText5);
        Submit = (Button) findViewById(R.id.button);
        AddData();
    }
    public void AddData(){
        Submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = Name.getText().toString();
                String setPassword = Password.getText().toString();
                String email = Email.getText().toString();
                String contact = Contact.getText().toString();
                if(name.isEmpty() || setPassword.isEmpty() || email.isEmpty() || contact.isEmpty())
                {
                    Toast.makeText(MainActivity.this, "Enter Credentials", Toast.LENGTH_LONG).show();
                }
                else {
                    HashMap<String,String> credentials=new HashMap<>();

                    //credentials.put("name", name);
                    credentials.put("phone", contact);
                    credentials.put("password", setPassword);
                    //credentials.put("email", email);



                    Call<Void>call = retrofitInterface.executeSignup(credentials);

                    call.enqueue(new Callback<Void>() {
                        @Override
                        public void onResponse(Call<Void> call, Response<Void> response) {

                            if(response.code()==200)
                                Toast.makeText(MainActivity.this, "Registration Successful", Toast.LENGTH_LONG).show();

                            else if(response.code()==400)
                                Toast.makeText(MainActivity.this, "This username is already registered, Please login", Toast.LENGTH_LONG).show();
                        }

                        @Override
                        public void onFailure(Call<Void> call, Throwable t) {
                            Toast.makeText(MainActivity.this, "Please try again", Toast.LENGTH_LONG).show();
                        }
                    });

                }
                Name.setText("");
                Password.setText("");
                Email.setText("");
                Contact.setText("");

            }
        });
    }
}

