package com.example.tongue;

import android.content.Intent;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import com.example.tongue.activities.HomeActivity;
import com.example.tongue.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    // PRESENTATION ACTIVITY
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        binding.button.setAlpha(0);
        CardView cardView = (CardView) findViewById(R.id.mainCard);
        cardView.setAlpha(0);
        Animation animSlide = AnimationUtils.loadAnimation(getApplicationContext(),
                R.anim.slide);
        cardView.startAnimation(animSlide);
        cardView.animate().setDuration(1200).alpha(1);
        binding.button.animate().setDuration(1600).alpha(1);
        binding.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), HomeActivity.class);
                startActivity(intent);
            }
        });
    }


}
