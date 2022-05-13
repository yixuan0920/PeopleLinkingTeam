package com.example.fragmentnavigationbottom;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class SettingsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getSupportFragmentManager().beginTransaction()
                .replace(android.R.id.content,
                        new SettingsFragment()).commit();

//        setContentView(R.layout.content);
//
//        nameInput = findViewById(R.id.nameInput);
//        emailInput = findViewById(R.id.emailInput);
//        phoneInput = findViewById(R.id.phoneInput);
//        addressInput = findViewById(R.id.addressInput);
//        passwordInput = findViewById(R.id.passwordInput);
//        ageInput = findViewById(R.id.ageInput);
//        dob = findViewById(R.id.dateInput);
    }


}