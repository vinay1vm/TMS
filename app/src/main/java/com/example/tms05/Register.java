package com.example.tms05;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.vishnusivadas.advanced_httpurlconnection.PutData;


public class Register extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        getSupportActionBar().hide();

        EditText name=findViewById(R.id.regname);
        EditText email=findViewById(R.id.regEmail);
        EditText doorno=findViewById(R.id.regdno);
        EditText phno=findViewById(R.id.regphNo);
        EditText Rpassword=findViewById(R.id.regpass);
        Button submitbtn=findViewById(R.id.regsubmitbtn);



        submitbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                String names= name.getText().toString();
                String emails= email.getText().toString();
                String doornos= doorno.getText().toString();
                String phnos= phno.getText().toString();
                String Rpasswords= Rpassword.getText().toString();

                if(names.isEmpty() || emails.isEmpty() || doornos.isEmpty() || phnos.isEmpty() || Rpasswords.isEmpty()){
                    Toast.makeText(Register.this, "Fields cant be empty", Toast.LENGTH_SHORT).show();

                }
                else {


                    //Start ProgressBar first (Set visibility VISIBLE)
                    Handler handler = new Handler(Looper.getMainLooper());
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            //Starting Write and Read data with URL
                            //Creating array for parameters
                            String[] field = new String[5];
                            field[0] = "door_no";
                            field[1] = "full_name";
                            field[2] = "email";
                            field[3] = "phone_no";
                            field[4] = "password";
                            //Creating array for data
                            String[] data = new String[5];
                            data[0] = doornos;
                            data[1] = names;
                            data[2] = emails;
                            data[3] = phnos;
                            data[4] = Rpasswords;
                            PutData putData = new PutData("http://172.20.10.4/TMS_Residents/signup.php", "POST", field, data);
                            if (putData.startPut()) {
                                if (putData.onComplete()) {
                                    String result = putData.getResult();
                                    if(result.equals("Sign Up Success")){

                                        Toast.makeText(getApplicationContext(),result, Toast.LENGTH_SHORT).show();
                                        startActivity(new Intent(Register.this,MainActivity.class));
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




    }
}