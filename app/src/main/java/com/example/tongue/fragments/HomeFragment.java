package com.example.tongue.fragments;

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

import org.jetbrains.annotations.NotNull;

import java.util.List;

public class HomeFragment extends Fragment {

    // Fields
    private HomeViewModel homeViewModel;
    public FragmentHomeBinding binding;
    private StoreAdapter adapter;


    @Override
    public void onViewCreated(@NonNull @NotNull View view, @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState){
        // Usual instantiation
        homeViewModel =
                new ViewModelProvider(this).get(HomeViewModel.class);

        binding = FragmentHomeBinding.inflate(inflater, (ViewGroup) container, false);
        View root = binding.getRoot();

        // Store variant recycler view click listener
        List<StoreVariant> storeVariants = StoreVariantGenerator.getStores(20);
        LinearLayoutManager manager = new LinearLayoutManager(this.getContext());
        manager.setOrientation(LinearLayoutManager.VERTICAL);
        binding.fragmentHomeRecyclerview.setLayoutManager(manager);
        adapter = new StoreAdapter(storeVariants, new StoreClickListener() {
            @Override
            public void onStoreVariantClicked(StoreVariant storeVariant, View view) {
                //System.out.println("binding: "+binding.fragmentHomeRecyclerview.getChildPosition((View) view.getParent()));
                //int y = (int) view.getY();
                //System.out.println("Position view: "+y);
                //binding.getRoot().smoothScrollTo(0,y);
                Intent intent = new Intent(getContext(), StoreVariantHomeActivity.class);
                startActivity(intent);

            }
        });

        // Recycler view setting


        binding.fragmentHomeRecyclerview.setAdapter(adapter);

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
