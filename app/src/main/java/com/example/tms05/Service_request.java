package com.example.tms05;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

public class Service_request extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service_request);
        getSupportActionBar().hide();



        String[] arraySpinner = new String[] {" ", "Plumber", "Laundry", "Electrican"};
        Spinner s = (Spinner) findViewById(R.id.serviceList);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, arraySpinner);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        s.setAdapter(adapter);


        Button submitSR=findViewById(R.id.SrSubmit);

        submitSR.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                Toast.makeText(Service_request.this, "Request Sent", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(Service_request.this,Resident_home.class));



            }
        });


    }
}