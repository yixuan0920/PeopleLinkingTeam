package com.example.fragmentnavigationbottom.ui.scan;

import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.fragmentnavigationbottom.R;

public class QrScanningFragment extends Fragment {

    private QrScaningViewModel mViewModel;

    public static QrScanningFragment newInstance() {
        return new QrScanningFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_qr_scanning, container, false);

        //Onclick button listener for updateProfileBtn
        Button button = (Button) view.findViewById(R.id.go_to_scan);
        button.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                //Code to navigation from fragment to fragment
                NavHostFragment.findNavController(QrScanningFragment.this)
                        .navigate(R.id.action_navigation_qr_scan_to_navigation_scan);
            }
        });

        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(QrScaningViewModel.class);
        // TODO: Use the ViewModel
    }

}