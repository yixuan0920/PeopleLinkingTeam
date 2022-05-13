package com.example.fragmentnavigationbottom.ui.hotspot;

import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.fragmentnavigationbottom.R;
import com.example.fragmentnavigationbottom.ui.scan.ScanViewModel;

public class HotspotFragment extends Fragment {

    private HotspotViewModel mViewModel;

    public static HotspotFragment newInstance() {
        return new HotspotFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_hotspot, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(HotspotViewModel.class);
        // TODO: Use the ViewModel
    }

}