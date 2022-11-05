package com.example.tms05;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.vishnusivadas.advanced_httpurlconnection.PutData;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();

         EditText username=findViewById(R.id.username);
         EditText password=findViewById(R.id.pass);
         Button login=findViewById(R.id.loginbtn);
         TextView register=findViewById(R.id.register);


         login.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {

                 String Username= username.getText().toString();
                 String pass= password.getText().toString();

                 if(Username.isEmpty() || pass.isEmpty()){

                     Toast.makeText(MainActivity.this, "Fields cant be empty", Toast.LENGTH_SHORT).show();
                 }
                 else {
                     //Start ProgressBar first (Set visibility VISIBLE)
                     Handler handler = new Handler(Looper.getMainLooper());
                     handler.post(new Runnable() {
                         @Override
                         public void run() {
                             //Starting Write and Read data with URL
                             //Creating array for parameters
                             String[] field = new String[2];
                             field[0] = "email";
                             field[1] = "password";

                             //Creating array for data
                             String[] data = new String[2];
                             data[0] = Username;
                             data[1] = pass;

                             PutData putData = new PutData("http://172.20.10.4/TMS_Residents/login.php", "POST", field, data);
                             if (putData.startPut()) {
                                 if (putData.onComplete()) {
                                     String result = putData.getResult();
                                     if(result.equals("Login Success")){

                                         Toast.makeText(getApplicationContext(),result, Toast.LENGTH_SHORT).show();
                                         startActivity(new Intent(MainActivity.this,Resident_home.class));
                                         finish();

                                     }
                                     else{
                                         Toast.makeText(getApplicationContext(),result, Toast.LENGTH_SHORT).show();
                                     }

                                 }
                             }
                             //End Write and Read data with URL
                         }
                     });
                 }
             }
         });


        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,Register.class));
            }
        });


    }
}