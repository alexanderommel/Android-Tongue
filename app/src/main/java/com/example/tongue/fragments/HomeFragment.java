package com.example.tongue.fragments;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.tongue.activities.StoreVariantHomeActivity;
import com.example.tongue.databinding.FragmentHomeBinding;
import com.example.tongue.viewmodels.HomeViewModel;
import com.example.tongue.adapters.StoreAdapter;
import com.example.tongue.models.StoreVariant;
import com.example.tongue.interfaces.StoreClickListener;
import com.example.tongue.testingdata.StoreVariantGenerator;
import com.example.tongue.viewmodels.SharedCartViewModel;
import com.example.tongue.viewmodels.SharedCheckoutViewModel;

import org.jetbrains.annotations.NotNull;

import java.util.List;

public class HomeFragment extends Fragment {

    // Fields
    private HomeViewModel homeViewModel;
    public FragmentHomeBinding binding;
    private StoreAdapter adapter;
    private OnStoreSelectedListener listener;
    private OnMenuImageClickListener menuListener;


    @Override
    public void onViewCreated(@NonNull @NotNull View view, @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState){

        // Init
        homeViewModel =
                new ViewModelProvider(this).get(HomeViewModel.class);

        binding = FragmentHomeBinding.inflate(inflater, (ViewGroup) container, false);
        View root = binding.getRoot();
        binding.fragmentHomeCheckoutLayout.setVisibility(View.GONE);

        // MenuImage click listener
        binding.appHomeMenuIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                menuListener.onMenuImageClicked();
            }
        });

        // Store variant recycler view click listener
        List<StoreVariant> storeVariants = StoreVariantGenerator.getStores(20);
        LinearLayoutManager manager = new LinearLayoutManager(this.getContext());
        manager.setOrientation(LinearLayoutManager.VERTICAL);
        binding.fragmentHomeRecyclerview.setLayoutManager(manager);
        adapter = new StoreAdapter(storeVariants, new StoreClickListener() {
            @Override
            public void onStoreVariantClicked(StoreVariant storeVariant, View view) {
                listener.onStoreSelected(storeVariant);
            }
        });

        // Recycler view setting


        binding.fragmentHomeRecyclerview.setAdapter(adapter);
        SharedCheckoutViewModel model = new ViewModelProvider(requireActivity()).get(SharedCheckoutViewModel.class);
        model.getCheckout().observe(getViewLifecycleOwner(), cart -> {
            System.out.println("called788");
            binding.fragmentHomeCheckoutLayout.setVisibility(View.VISIBLE);
        });


        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    @Override
    public void onAttach(@NonNull @NotNull Context context) {
        super.onAttach(context);
        try {
            listener = (HomeFragment.OnStoreSelectedListener) context;
        } catch (ClassCastException e){
            throw new ClassCastException(context.toString()+ "must implement OnStoreSelectedListener");
        }
        try {
            menuListener = (HomeFragment.OnMenuImageClickListener) context;
        } catch (ClassCastException e){
            throw new ClassCastException(context.toString()+ "must implement OnMenuImageClickListener");
        }
    }

    public interface OnStoreSelectedListener {
        public void onStoreSelected(StoreVariant storeVariant);
    }

    public interface OnMenuImageClickListener {
        public void onMenuImageClicked();
    }

}
