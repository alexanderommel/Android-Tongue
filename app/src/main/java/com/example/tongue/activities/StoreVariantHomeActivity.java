package com.example.tongue.activities;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tongue.R;
import com.example.tongue.databinding.StoreVariantHomeBinding;
import com.example.tongue.fragments.ProductFragment;
import com.example.tongue.fragments.StoreVariantDescriptionFragment;
import com.example.tongue.models.Cart;
import com.example.tongue.models.LineItem;
import com.example.tongue.models.Product;
import com.example.tongue.models.StoreVariant;
import com.example.tongue.viewmodels.SharedCartViewModel;
import com.example.tongue.viewmodels.SharedCheckoutViewModel;

public class StoreVariantHomeActivity extends AppCompatActivity
        implements
        ProductFragment.OnLineItemAddedListener{

    private StoreVariantHomeBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        // Custom setting
        super.onCreate(savedInstanceState);
        binding = StoreVariantHomeBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // ViewModel

        // Fragment initial allocation
        if (savedInstanceState==null){
            Fragment descriptionFragment = new StoreVariantDescriptionFragment();
            FragmentManager manager = getSupportFragmentManager();
            manager.beginTransaction()
                    .add(R.id.store_variant_home_fragment, descriptionFragment)
                    .commit();
        }

    }

    @Override
    public void OnLineItemAdded(LineItem lineItem) {
    }

}
