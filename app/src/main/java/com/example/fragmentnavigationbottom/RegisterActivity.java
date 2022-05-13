package com.example.fragmentnavigationbottom;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.NumberPicker;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import java.util.Calendar;
import android.app.DatePickerDialog;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.snackbar.Snackbar;

public class RegisterActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {


    SharedPreferences sharedpreferences;
    EditText nameInput;
    EditText emailInput;
    EditText phoneInput;
    EditText addressInput;
    EditText passwordInput;
    NumberPicker ageInput;
    Spinner gender;
    EditText dob;
    DatePickerDialog picker;
    Button buttonRegister;

    //public static final String mypreference = "com.example.fragmentnavigationbottom.ui.profile.regpref";
    public static final String mypreference = "regpref";
    public static final String NameInput = "nameInputKey";
    public static final String EmailInput = "emailInputKey";
    public static final String PhoneInput = "phoneInputKey";
    public static final String AddressInput = "addressInputKey";
    public static final String PasswordInput = "passwordInputKey";
    public static final String AgeInput = "ageInputKey";
    public static final String Gender = "genderKey";
    public static final String Gender2 = "genderKeyPos";
    public static final String DOB = "DOBKey";


    String[] genders = { "Others", "Female", "Male"};

    String gender_selected = "";
    int gender_pos_selected = 0;

    ArrayAdapter<CharSequence> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        nameInput = findViewById(R.id.nameInput);
        emailInput = findViewById(R.id.emailInput);
        phoneInput = findViewById(R.id.phoneInput);
        addressInput = findViewById(R.id.addressInput);
        passwordInput = findViewById(R.id.passwordInput);
        ageInput = findViewById(R.id.ageInput);
        dob = findViewById(R.id.dateInput);

        //Initialize NumberPicker for age
        if(ageInput != null){
            ageInput.setMinValue(0);
            ageInput.setMaxValue(150);
            ageInput.setWrapSelectorWheel(true);
        }

        gender = findViewById(R.id.genderInput);
        gender.setOnItemSelectedListener(this);
        // Create an ArrayAdapter using the string array and a default spinner layout
        adapter = ArrayAdapter.createFromResource(this,
                R.array.gender_array, android.R.layout.simple_spinner_item);
        // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        gender.setAdapter(adapter);


        // Datepicker for DOB
        // https://www.tutlane.com/tutorial/android/android-datepicker-with-examples
        dob.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Calendar cldr = Calendar.getInstance();
                int day = cldr.get(Calendar.DAY_OF_MONTH);
                int month = cldr.get(Calendar.MONTH);
                int year = cldr.get(Calendar.YEAR);
                // date picker dialog
                picker = new DatePickerDialog(RegisterActivity.this,
                        new DatePickerDialog.OnDateSetListener() {
                            @Override
                            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                                dob.setText(dayOfMonth + "/" + (monthOfYear + 1) + "/" + year);
                            }
                        }, year, month, day);
                picker.show();
            }
        });

        buttonRegister = findViewById(R.id.buttonRegister);
        buttonRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Retrieve values from shared preference
                sharedpreferences = getSharedPreferences(mypreference, Context.MODE_PRIVATE);

//                String.valueOf(ageInput);

                if(TextUtils.isEmpty(nameInput.getText()) ||
                        TextUtils.isEmpty(emailInput.getText()) ||
                        TextUtils.isEmpty(addressInput.getText()) ||
                        TextUtils.isEmpty(passwordInput.getText()) ||
                        TextUtils.isEmpty(phoneInput.getText()) ||
                        TextUtils.isEmpty(dob.getText())){
                    Toast.makeText(RegisterActivity.this,"Please fill out the from.",Toast.LENGTH_SHORT).show();
                }
                else{
                    String n = nameInput.getText().toString();
                    String e = emailInput.getText().toString();
                    String pn = phoneInput.getText().toString();
                    String a = addressInput.getText().toString();
                    String p = passwordInput.getText().toString();
                    String d = dob.getText().toString();
                    int age = ageInput.getValue();

                    SharedPreferences.Editor editor = sharedpreferences.edit();
                    editor.putString(NameInput, n);
                    editor.putString(EmailInput, e);
                    editor.putString(PhoneInput, pn);
                    editor.putString(AddressInput, a);
                    editor.putString(PasswordInput, p);
                    editor.putString(DOB, d);
                    editor.putString(Gender,gender_selected);
                    editor.putInt(Gender2,gender_pos_selected);
                    editor.putInt(AgeInput, age);
                    editor.commit();

                    //Login successful
                    startActivity(new Intent(RegisterActivity.this, LoginActivity.class));
                }
            }
        });
    }

    public void onItemSelected(AdapterView<?> parent, View view,
                               int pos, long id) {
        // An item was selected. You can retrieve the selected item using
        // parent.getItemAtPosition(pos)
        // make toastof name of gender
        // which is selected in spinner
        Toast.makeText(getApplicationContext(),
                genders[pos],
                Toast.LENGTH_LONG)
                .show();


        gender_selected = genders[pos];
        gender_pos_selected = pos;
    }

    public void onNothingSelected(AdapterView<?> parent) {
        // Another interface callback
    }

    public void goToLogin(View view){
        startActivity(new Intent(RegisterActivity.this, LoginActivity.class));
    }
    public void goToResetPassword(View view) {
        startActivity(new Intent(RegisterActivity.this, ResetPasswordActivity.class));
    }

}