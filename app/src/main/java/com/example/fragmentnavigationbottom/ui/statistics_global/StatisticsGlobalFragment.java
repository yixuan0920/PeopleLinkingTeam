package com.example.fragmentnavigationbottom.ui.statistics_global;

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

public class StatisticsGlobalFragment extends Fragment {

    private StatisticsGlobalViewModel mViewModel;

    public static StatisticsGlobalFragment newInstance() {
        return new StatisticsGlobalFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_statistics_global, container, false);

        //Onclick button listener for updateProfileBtn
        Button button = (Button) view.findViewById(R.id.back_to_statistics_main);
        button.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                //Code to navigation from fragment to fragment
                NavHostFragment.findNavController(StatisticsGlobalFragment.this)
                        .navigate(R.id.action_navigation_statistics_global_to_navigation_statistics);
            }

        });

        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(StatisticsGlobalViewModel.class);
        // TODO: Use the ViewModel
    }

}