package com.example.tongue.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.AppBarConfiguration;

import com.example.tongue.R;
import com.example.tongue.databinding.ActivityHomeBinding;
import com.example.tongue.fragments.HomeFragment;
import com.example.tongue.fragments.ProductFragment;
import com.example.tongue.fragments.StoreVariantDescriptionFragment;
import com.example.tongue.models.LineItem;
import com.example.tongue.models.Product;
import com.example.tongue.models.StoreVariant;
import com.example.tongue.viewmodels.SharedCartViewModel;
import com.example.tongue.viewmodels.SharedCheckoutViewModel;
import com.google.android.material.navigation.NavigationView;

public class HomeActivity extends AppCompatActivity
        implements HomeFragment.OnStoreSelectedListener
        ,HomeFragment.OnMenuImageClickListener
        ,StoreVariantDescriptionFragment.OnProductSelectedListener
        ,ProductFragment.OnLineItemAddedListener
        ,HomeFragment.OnViewOrderSelectedListener{

    // Fields
    private AppBarConfiguration appBarConfiguration;
    public ActivityHomeBinding binding;
    public  DrawerLayout drawer;
    private NavController navController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        // Trivial
        super.onCreate(savedInstanceState);
        binding = ActivityHomeBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        drawer = binding.homeDrawerLayout;
        NavHostFragment navHostFragment =
                (NavHostFragment) getSupportFragmentManager().findFragmentById(R.id.nav_host_fragment);
        navController = navHostFragment.getNavController();

        //home.binding.fragmentHomeCheckoutLayout.setVisibility(View.GONE);

    }

    @Override
    public void onStoreSelected(StoreVariant storeVariant) {
        navController.navigate(R.id.action_nav_home_to_storeVariantDescriptionFragment);
    }

    @Override
    public void OnLineItemAdded(LineItem lineItem) {
        navController.navigate(R.id.action_productFragment_to_storeVariantDescriptionFragment);
    }

    @Override
    public void onProductSelected(Product product) {
        navController.navigate(R.id.action_storeVariantDescriptionFragment_to_productFragment);
    }

    @Override
    public void onMenuImageClicked() {
        drawer.openDrawer(GravityCompat.START);
    }

    @Override
    public void onViewOrderClicked() {
        navController.navigate(R.id.action_nav_home_to_cartFragment);
    }
}
