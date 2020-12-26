package com.example.divyashreesoni.practice;

import android.app.AlertDialog;
import android.content.Intent;
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

public class login extends AppCompatActivity {

    DatabaseHelper myDb;
    private Retrofit retrofit;
    private RetrofitInterface retrofitInterface;
    private String BASE_URL="http:// localhost:3000";

    Button REGISTER, signin;
    EditText username, password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        retrofit=new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        retrofitInterface=retrofit.create(RetrofitInterface.class);

        username = (EditText) findViewById(R.id.e1);
        password = (EditText) findViewById(R.id.e2);
        signin = (Button) findViewById(R.id.login);
        REGISTER = (Button) findViewById(R.id.register);
        verifyData();


        REGISTER.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(login.this, MainActivity.class);
                startActivity(i);

            }
        });
    }



    public void verifyData(){
        signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String phone = username.getText().toString();
                String passkey = password.getText().toString();
                if(phone.isEmpty() || passkey.isEmpty())
                {
                    Toast.makeText(login.this, "Enter Credentials", Toast.LENGTH_LONG).show();
                }
                else {

                    HashMap<String,String>credentials = new HashMap<>();

                    credentials.put("username", phone);
                    credentials.put("password", passkey);

                    Call<LoginResult> call= retrofitInterface.executeLogin(credentials);

                    call.enqueue(new Callback<LoginResult>() {
                        @Override
                        public void onResponse(Call<LoginResult> call, Response<LoginResult> response) {

                            if(response.code()==200){
                                Intent i = new Intent(login.this, Main2Activity.class);
                                startActivity(i);
                            }

                            else if(response.code()==404){
                                Toast.makeText(login.this, "Invalid Username or Password", Toast.LENGTH_SHORT).show();
                            }
                        }

                        @Override
                        public void onFailure(Call<LoginResult> call, Throwable t) {
                            Toast.makeText(login.this, "Your password is incorrect", Toast.LENGTH_LONG).show();
                        }
                    });


                }

            }
        });
    }


}
