package com.example.fragmentnavigationbottom.ui.statistics_local;

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
import com.example.fragmentnavigationbottom.ui.scan.ScanFragment;

public class StatisticsLocalFragment extends Fragment {

    private StatisticsLocalViewModel mViewModel;

    public static StatisticsLocalFragment newInstance() {
        return new StatisticsLocalFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_statistics_local, container, false);

        //Onclick button listener for updateProfileBtn
        Button button = (Button) view.findViewById(R.id.back_to_statistics_main);
        button.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                //Code to navigation from fragment to fragment
                NavHostFragment.findNavController(StatisticsLocalFragment.this)
                        .navigate(R.id.action_navigation_statistics_local_to_navigation_statistics);
            }

        });

        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(StatisticsLocalViewModel.class);
        // TODO: Use the ViewModel
    }

}