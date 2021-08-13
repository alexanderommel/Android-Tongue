package com.example.tongue.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.ui.AppBarConfiguration;

import com.example.tongue.R;
import com.example.tongue.databinding.ActivityHomeBinding;
import com.example.tongue.fragments.HomeFragment;
import com.example.tongue.models.StoreVariant;
import com.example.tongue.viewmodels.SharedCartViewModel;
import com.example.tongue.viewmodels.SharedCheckoutViewModel;
import com.google.android.material.navigation.NavigationView;

public class HomeActivity extends AppCompatActivity implements HomeFragment.OnStoreSelectedListener {

    private AppBarConfiguration appBarConfiguration;
    public ActivityHomeBinding binding;
    public  DrawerLayout drawer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityHomeBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        drawer = binding.homeDrawerLayout;
        Fragment navHostFragment =
                getSupportFragmentManager().findFragmentById(R.id.nav_host_fragment_container);
        HomeFragment home = (HomeFragment) navHostFragment.getChildFragmentManager().getFragments().get(0);

        home.binding.appHomeMenuIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawer.openDrawer(GravityCompat.START);
            }
        });

        //home.binding.fragmentHomeCheckoutLayout.setVisibility(View.GONE);

    }

    @Override
    public void onStoreSelected(StoreVariant storeVariant) {
        Intent intent = new Intent(this, StoreVariantHomeActivity.class);
        startActivity(intent);
    }
}
