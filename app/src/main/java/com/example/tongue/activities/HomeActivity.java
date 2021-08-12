package com.example.tongue.activities;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.navigation.ui.AppBarConfiguration;

import com.example.tongue.R;
import com.example.tongue.databinding.ActivityHomeBinding;
import com.example.tongue.fragments.HomeFragment;
import com.google.android.material.navigation.NavigationView;

public class HomeActivity extends AppCompatActivity {

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

        NavigationView navigationView = binding.navView;

    }
}
