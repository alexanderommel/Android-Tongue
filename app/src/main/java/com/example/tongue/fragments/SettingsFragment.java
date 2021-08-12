package com.example.tongue.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.tongue.databinding.FragmentHomeBinding;
import com.example.tongue.viewmodels.SettingsViewModel;

public class SettingsFragment  extends Fragment {

    private SettingsViewModel settingsViewModel;
    private FragmentHomeBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState){
        settingsViewModel = new ViewModelProvider(this).get(SettingsViewModel.class);
        binding = FragmentHomeBinding.inflate(inflater,container,false);
        View root = binding.getRoot();
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
