package com.example.tongue.activities;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import androidx.recyclerview.widget.RecyclerView;

import com.example.tongue.R;
import com.example.tongue.databinding.StoreVariantHomeBinding;
import com.example.tongue.fragments.ProductFragment;
import com.example.tongue.fragments.StoreVariantDescriptionFragment;
import com.example.tongue.models.Product;

public class StoreVariantHomeActivity extends AppCompatActivity implements StoreVariantDescriptionFragment.OnProductSelectedListener {

    private StoreVariantHomeBinding binding;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        // Custom setting
        super.onCreate(savedInstanceState);
        binding = StoreVariantHomeBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        if (savedInstanceState==null){
            Fragment descriptionFragment = new StoreVariantDescriptionFragment();
            FragmentManager manager = getSupportFragmentManager();
            manager.beginTransaction()
                    .add(R.id.store_variant_home_fragment, descriptionFragment)
                    .commit();
        }
    }

    @Override
    public void onProductSelected(Product product) {
        Fragment productFragment = new ProductFragment();
        FragmentManager manager = getSupportFragmentManager();
        manager.beginTransaction()
                .setCustomAnimations(
                        R.anim.slide_in,  // enter
                        R.anim.fade_out,  // exit
                        R.anim.fade_in,   // popEnter
                        R.anim.slide_out  // popExit
                )
                .replace(R.id.store_variant_home_fragment, productFragment)
                .addToBackStack(null).commit();
    }
}
