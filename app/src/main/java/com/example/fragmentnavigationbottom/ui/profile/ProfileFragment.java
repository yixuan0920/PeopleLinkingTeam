package com.example.fragmentnavigationbottom.ui.profile;

import androidx.lifecycle.ViewModelProvider;

import android.app.DatePickerDialog;
import android.content.Context;
import android.content.Intent;
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
import android.widget.NumberPicker;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.fragmentnavigationbottom.DashboardActivity;
import com.example.fragmentnavigationbottom.LoginActivity;
import com.example.fragmentnavigationbottom.R;

import org.w3c.dom.Text;

public class ProfileFragment extends Fragment {

    private ProfileViewModel mViewModel;

//    SharedPreferences sharedpreferences = this.getActivity().getSharedPreferences("regpref", Context.MODE_PRIVATE);

    SharedPreferences sharedpreferences;
    TextView nameInput, emailInput, phoneInput, addressInput;

    public static final String mypreference = "regpref";
    public static final String NameInput = "nameInputKey";
    public static final String EmailInput = "emailInputKey";
    public static final String PhoneInput = "phoneInputKey";
    public static final String AddressInput = "addressInputKey";
    public static ProfileFragment newInstance() {
        return new ProfileFragment();
    }


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_profile, container, false);
        nameInput = view.findViewById(R.id.nameInput);
        emailInput = view.findViewById(R.id.emailInput);
        phoneInput = view.findViewById(R.id.phoneInput);
        addressInput = view.findViewById(R.id.addressInput);

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

        //button listener editProfileBtn
        Button button = (Button) view.findViewById(R.id.editButton);
        button.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                //Code to navigation from fragment to fragment
                NavHostFragment.findNavController(ProfileFragment.this)
                        .navigate(R.id.action_navigation_profile_to_navigation_edit_profile);
            }
        });

        return view;
    }

}