package com.example.fragmentnavigationbottom.ui.profile;

import androidx.lifecycle.ViewModelProvider;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.fragmentnavigationbottom.R;
import com.example.fragmentnavigationbottom.ui.scan.ScanFragment;

public class EditProfileFragment extends Fragment {

    private EditProfileViewModel mViewModel;

    SharedPreferences sharedpreferences;
    EditText nameInput, emailInput, phoneInput, addressInput, passwordInput;

    public static final String mypreference = "regpref";
    public static final String NameInput = "nameInputKey";
    public static final String EmailInput = "emailInputKey";
    public static final String PhoneInput = "phoneInputKey";
    public static final String AddressInput = "addressInputKey";
    public static final String PasswordInput = "passwordInputKey";

    public static EditProfileFragment newInstance() {
        return new EditProfileFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_edit_profile, container, false);

        nameInput = view.findViewById(R.id.nameInput);
        emailInput = view.findViewById(R.id.emailInput);
        phoneInput = view.findViewById(R.id.phoneInput);
        addressInput = view.findViewById(R.id.addressInput);
        passwordInput = view.findViewById(R.id.passwordInput);



        sharedpreferences = getActivity().getSharedPreferences(mypreference,
                Context.MODE_PRIVATE);
        if (sharedpreferences.contains(NameInput)) {
            nameInput.setText(sharedpreferences.getString(NameInput, ""));
        }
        if (sharedpreferences.contains(EmailInput)) {
            emailInput.setText(sharedpreferences.getString(EmailInput, ""));
        }
        if (sharedpreferences.contains(PhoneInput)) {
            phoneInput.setText(sharedpreferences.getString(PhoneInput, ""));
        }
        if (sharedpreferences.contains(AddressInput)) {
            addressInput.setText(sharedpreferences.getString(AddressInput, ""));
        }


        Button button2 = (Button) view.findViewById(R.id.go_to_profile);
        button2.setOnClickListener(new View.OnClickListener()
        {
            Activity activity = getActivity();
            @Override
            public void onClick(View v)
            {
                //Code to navigation from fragment to fragment
                NavHostFragment.findNavController(EditProfileFragment.this)
                        .navigate(R.id.action_navigation_edit_profile_to_navigation_profile);
            }
        });

        Button button3 = (Button) view.findViewById(R.id.buttonSave);
        button3.setOnClickListener(new View.OnClickListener()
        {
            Activity activity = getActivity();
            @Override
            public void onClick(View v) {
                String n = nameInput.getText().toString();
                String e = emailInput.getText().toString();
                String pn = phoneInput.getText().toString();
                String a = addressInput.getText().toString();
                String p = passwordInput.getText().toString();
                SharedPreferences.Editor editor = sharedpreferences.edit();

                editor.putString(NameInput, n);
                editor.putString(EmailInput, e);
                editor.putString(PhoneInput, pn);
                editor.putString(AddressInput, a);
                editor.putString(PasswordInput, p);
                editor.commit();
            }
        });

        Button button4 = (Button) view.findViewById(R.id.buttonRetrieve);
        button4.setOnClickListener(new View.OnClickListener()
        {
            Activity activity = getActivity();
            @Override
            public void onClick(View v){
                    nameInput = view.findViewById(R.id.nameInput);
                    emailInput = view.findViewById(R.id.emailInput);
                    phoneInput = view.findViewById(R.id.phoneInput);
                    addressInput = view.findViewById(R.id.addressInput);
                    passwordInput = view.findViewById(R.id.passwordInput);
                    retrieveFromSharedPreference();
                }

                private void retrieveFromSharedPreference() {
                    //Create SharedPreference object and access the shared preference file
                    //Open and retrieve the shared preference file
                    sharedpreferences = getActivity().getSharedPreferences(mypreference,
                            Context.MODE_PRIVATE);
                    //Check if the preference by the key "nameInputKey" exist
                    if (sharedpreferences.contains(NameInput)) {
                        //Set the edit text content to the value of "nameKey"
                        nameInput.setText(sharedpreferences.getString(NameInput, ""));
                    }
                    //Check if the preference by the key "stateDetailKey" exist
                    if (sharedpreferences.contains(EmailInput)) {
                        emailInput.setText(sharedpreferences.getString(EmailInput, ""));
                    }
                    if (sharedpreferences.contains(PhoneInput)) {
                        //Set the edit text content to the value of "nameKey"
                        phoneInput.setText(sharedpreferences.getString(PhoneInput, ""));
                    }
                    if (sharedpreferences.contains(AddressInput)) {
                        addressInput.setText(sharedpreferences.getString(AddressInput, ""));
                    }
                    if (sharedpreferences.contains(PasswordInput)) {
                        passwordInput.setText(sharedpreferences.getString(PasswordInput, ""));
                    }
                }
        });

        Button button5 = (Button) view.findViewById(R.id.buttonClear);
        button5.setOnClickListener(new View.OnClickListener()
        {
            Activity activity = getActivity();
            @Override
            public void onClick(View v) {
                Activity activity = getActivity();
                    nameInput.setText("");
                    emailInput.setText("");
                    phoneInput.setText("");
                    addressInput.setText("");
                    passwordInput.setText("");
                }
        });
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(EditProfileViewModel.class);
        // TODO: Use the ViewModel
    }
}