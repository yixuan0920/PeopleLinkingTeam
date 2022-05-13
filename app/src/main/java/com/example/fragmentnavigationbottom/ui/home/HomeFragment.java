package com.example.fragmentnavigationbottom.ui.home;

import androidx.lifecycle.ViewModelProvider;

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
import android.widget.TextView;

import com.example.fragmentnavigationbottom.DashboardActivity;
import com.example.fragmentnavigationbottom.LoginActivity;
import com.example.fragmentnavigationbottom.R;

public class HomeFragment extends Fragment {

    private HomeViewModel mViewModel;

    SharedPreferences sharedpreferences;
    TextView nameInput;

    public static final String mypreference = "regpref";
    public static final String NameInput = "nameInputKey";

    public static HomeFragment newInstance() {
        return new HomeFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        nameInput = view.findViewById(R.id.nameInput);

        sharedpreferences = getActivity().getSharedPreferences(mypreference,
                Context.MODE_PRIVATE);
        if (sharedpreferences.contains(NameInput)) {
            nameInput.setText(sharedpreferences.getString(NameInput, "Hi, "));
        }

        //button listener editProfileBtn
        Button button = (Button) view.findViewById(R.id.go_to_report);
        button.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                //Code to navigation from fragment to fragment
                NavHostFragment.findNavController(HomeFragment.this)
                        .navigate(R.id.action_navigation_home_to_navigation_report);
            }
        });
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(HomeViewModel.class);
        // TODO: Use the ViewModel
    }

}