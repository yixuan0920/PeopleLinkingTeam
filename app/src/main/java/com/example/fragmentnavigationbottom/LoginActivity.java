package com.example.fragmentnavigationbottom;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.material.snackbar.Snackbar;


public class LoginActivity extends AppCompatActivity {
    EditText emailInput;
    EditText passwordInput;
    Button buttonLogin;

    //For Shared Preference Set Up
    public static final String mypreference = "regpref";
    public static final String EmailInput = "emailInputKey";
    public static final String PasswordInput = "passwordInputKey";
    public static final String Active = "loginKey";

    SharedPreferences sharedpreferences;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        TextView btn = findViewById(R.id.textViewForgotPassword);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LoginActivity.this, ResetPasswordActivity.class));
            }
        });

        buttonLogin = findViewById(R.id.buttonLogin);
        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Authentication flow
                emailInput = findViewById(R.id.emailInput);
                passwordInput = findViewById(R.id.passwordInput);

                //Retrieve values from shared preference
                sharedpreferences = getSharedPreferences(mypreference,
                        Context.MODE_PRIVATE);

                if (sharedpreferences.contains(EmailInput) && sharedpreferences.contains(PasswordInput)){
                    //Username (emailInput) and password is the same as stored in shared preference

                    // emailInput entered = emailInput stored in SF && passwordInput entered = passwordInput stored in SF
                    if((emailInput.getText().toString().equals(sharedpreferences.getString(EmailInput, ""))) &&
                            (passwordInput.getText().toString().equals(sharedpreferences.getString(PasswordInput, ""))) )
                    {
                        //If the cookie for active session is not created yet
                        SharedPreferences.Editor editor = sharedpreferences.edit();
                        editor.putInt(Active, 1);
                        editor.commit();
                        //Login successful
                        startActivity(new Intent(LoginActivity.this, DashboardActivity.class));

                    }else{
                        //Login fail use Toast or Snackbar
                        //Toast.makeText(LoginActivity.this,"Username / Password failed. Please try again.",Toast.LENGTH_SHORT).show();

                        String message = "Username / Password failed. Please try again.";
                        int duration = Snackbar.LENGTH_SHORT;
                        Snackbar.make(v, message, duration).show();
                    }

                }else {
                    //error message use Toast or Snackbar

                    String message = "Username / Password is not recognized. Please try again.";
                    int duration = Snackbar.LENGTH_SHORT;
                    Snackbar.make(v, message, duration).show();
                }
            }
        });
    }

    public void goToRegister(View v) {
        startActivity(new Intent(LoginActivity.this, RegisterActivity.class));
    }

    public void goToResetPassword(View v) {
        startActivity(new Intent(LoginActivity.this, ResetPasswordActivity.class));
    }

}