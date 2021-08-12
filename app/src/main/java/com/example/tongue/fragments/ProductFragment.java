package com.example.tongue.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ScrollView;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.tongue.adapters.GroupModifierAdapter;
import com.example.tongue.databinding.ProductFragmentBinding;
import com.example.tongue.models.GroupModifier;
import com.example.tongue.models.Modifier;
import com.example.tongue.testingdata.ModifiersGenerator;
import com.example.tongue.viewmodels.ProductViewModel;

import java.util.List;

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

        // !!Temporal until Development of Tongue ViewModels!! (Bad Practice)
        List<List<Modifier>> modifiers = ModifiersGenerator.getModifierListsFromGroups();

        // GroupModifierRecyclerView population
        LinearLayoutManager manager = new LinearLayoutManager(getContext());
        GroupModifierAdapter adapter = new GroupModifierAdapter(modifiers);
        binding.productFragmentRecyclerView.setLayoutManager(manager);
        binding.productFragmentRecyclerView.setAdapter(adapter);

        return root;

    }
}
