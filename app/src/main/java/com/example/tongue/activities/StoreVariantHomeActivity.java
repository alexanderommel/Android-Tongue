package com.example.tongue.activities;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.navigation.ui.AppBarConfiguration;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tongue.R;
import com.example.tongue.databinding.ActivityHomeBinding;
import com.example.tongue.databinding.StoreVariantHomeBinding;
import com.example.tongue.fragments.store.ProductAdapter;
import com.example.tongue.fragments.store.StoreVariantSectionFragment;
import com.google.android.material.navigation.NavigationView;

import org.jetbrains.annotations.NotNull;

public class StoreVariantHomeActivity extends AppCompatActivity {

    private StoreVariantHomeBinding binding;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        // Custom setting
        super.onCreate(savedInstanceState);
        binding = StoreVariantHomeBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        //
    }
}
