package com.example.ruibabo.stadiumfinder;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.Spinner;


public class Registar extends AppCompatActivity {

    Spinner spinner;
    ArrayAdapter<String> dataAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registar);

        spinner = (Spinner) findViewById(R.id.spinner1);


        String[] value = {"Utilizador", "Clube"};


        dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, value);

        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinner.setAdapter(dataAdapter);
        final LinearLayout l1;
        l1 = findViewById(R.id.stadiumR);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

                switch (i) {
                    case 0:
                        l1.setVisibility(view.INVISIBLE);
                        break;
                    case 1:
                        l1.setVisibility(view.VISIBLE);
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }

}
