package com.example.tongue.activities;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.ui.AppBarConfiguration;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tongue.R;
import com.example.tongue.databinding.ActivityHomeBinding;
import com.example.tongue.databinding.StoreVariantHomeBinding;
import com.example.tongue.fragments.product.ProductFragment;
import com.example.tongue.fragments.store.ProductAdapter;
import com.example.tongue.fragments.store.StoreVariantDescriptionFragment;
import com.example.tongue.fragments.store.StoreVariantSectionFragment;
import com.example.tongue.models.Product;
import com.google.android.material.navigation.NavigationView;

import org.jetbrains.annotations.NotNull;

public class StoreVariantHomeActivity extends AppCompatActivity implements StoreVariantDescriptionFragment.OnProductSelectedListener {

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

    @Override
    public void onProductSelected(Product product) {
        System.out.println("test listener from activity");
        Fragment productFragment = new ProductFragment();
        FragmentManager manager = getSupportFragmentManager();
        manager.beginTransaction()
                .replace(R.id.store_variant_home_fragment, productFragment)
                .addToBackStack(null).commit();
    }
}
