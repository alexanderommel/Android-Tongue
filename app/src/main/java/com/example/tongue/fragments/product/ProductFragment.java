package com.example.tongue.fragments.product;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.tongue.databinding.FragmentHomeBinding;
import com.example.tongue.databinding.ProductFragmentBinding;
import com.example.tongue.fragments.home.HomeViewModel;

public class ProductFragment extends Fragment {

    // Fields
    private ProductFragmentBinding binding;
    private ProductViewModel productViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState){

        // Custom setting
        productViewModel =
                new ViewModelProvider(this).get(ProductViewModel.class);

        binding = ProductFragmentBinding.inflate(inflater, (ViewGroup) container, false);
        View root = binding.getRoot();

        return root;

    }
}
