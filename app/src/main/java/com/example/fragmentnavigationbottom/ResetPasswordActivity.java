package com.example.fragmentnavigationbottom;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class ResetPasswordActivity extends AppCompatActivity {

    Button buttonResetPasswordConfirm;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reset_password); //inflate
        buttonResetPasswordConfirm = findViewById(R.id.buttonResetPasswordConfirm);
        buttonResetPasswordConfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast toast = Toast.makeText(getApplicationContext(), "Password Updated!", Toast.LENGTH_SHORT);
                toast.show();
            }
        });
    }

    public void goToLogin(View v) {
        startActivity(new Intent(ResetPasswordActivity.this, LoginActivity.class));
    }
}