package com.example.fragmentnavigationbottom.ui.home;

import androidx.lifecycle.ViewModelProvider;

import android.app.Activity;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.example.fragmentnavigationbottom.R;
import com.example.fragmentnavigationbottom.ui.profile.EditProfileFragment;

public class ReportFragment extends Fragment {

    private ReportViewModel mViewModel;

    public static ReportFragment newInstance() {
        return new ReportFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_report, container, false);

        //Onclick button listener for updateProfileBtn
        Button button = (Button) view.findViewById(R.id.submit_report);
        button.setOnClickListener(new View.OnClickListener()
        {
            Activity activity = getActivity();
            @Override
            public void onClick(View v)
            {
                //Code to navigation from fragment to fragment
                NavHostFragment.findNavController(ReportFragment.this);
                Toast.makeText(activity,"Submit Successful!",Toast.LENGTH_SHORT).show();

            }
        });

        Button button2 = (Button) view.findViewById(R.id.go_to_home);
        button2.setOnClickListener(new View.OnClickListener()
        {
            Activity activity = getActivity();
            @Override
            public void onClick(View v)
            {
                //Code to navigation from fragment to fragment
                NavHostFragment.findNavController(ReportFragment.this)
                        .navigate(R.id.action_navigation_report_to_navigation_home);
            }
        });

        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(ReportViewModel.class);
        // TODO: Use the ViewModel
    }

}