package com.example.tongue.fragments;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.tongue.adapters.GroupModifierAdapter;
import com.example.tongue.databinding.FragmentCheckoutBinding;
import com.example.tongue.databinding.ProductFragmentBinding;
import com.example.tongue.models.LineItem;
import com.example.tongue.models.Modifier;
import com.example.tongue.models.Product;
import com.example.tongue.testingdata.ModifiersGenerator;
import com.example.tongue.viewmodels.ProductViewModel;
import com.example.tongue.viewmodels.SharedCartViewModel;

import org.jetbrains.annotations.NotNull;

import java.util.List;

public class CheckoutFragment extends Fragment {

    // Fields
    private FragmentCheckoutBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState){

        // Custom setting
        binding = FragmentCheckoutBinding.inflate(inflater, (ViewGroup) container, false);
        View root = binding.getRoot();



        return root;

    }

}
