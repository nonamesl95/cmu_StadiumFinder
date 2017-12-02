package com.example.ruibabo.stadiumfinder;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.Toast;


public class Registar extends AppCompatActivity {

    Spinner spinner;
    ArrayAdapter<String> dataAdapter;
    DbHelper dbHelper;
    EditText user, pass;
    Button btnSignUp;
    boolean userType = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registar);

        spinner = (Spinner) findViewById(R.id.spinner1);
        user = findViewById(R.id.userNameReg);
        pass = findViewById(R.id.passwordReg);

        dbHelper = new DbHelper(this);

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
                        l1.setVisibility(View.INVISIBLE);


                        break;
                    case 1:
                        l1.setVisibility(View.VISIBLE);

                        userType = true;
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }

        });


        btnSignUp = findViewById(R.id.signBtn);


        btnSignUp.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                boolean isInserted = dbHelper.insertData(user.getText().toString(), pass.getText().toString(), userType);

                if (isInserted && userType == true) {

                    Toast.makeText(Registar.this, "Clube Registado", Toast.LENGTH_SHORT).show();

                } else if (isInserted && userType == false) {

                    Toast.makeText(Registar.this, "User Registado", Toast.LENGTH_SHORT).show();

                } else {
                    Toast.makeText(Registar.this, "Data Not Inserted", Toast.LENGTH_SHORT).show();
                }

                Intent int1 = new Intent(Registar.this, MainActivity.class);
                startActivity(int1);

            }
        });


    }


    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
