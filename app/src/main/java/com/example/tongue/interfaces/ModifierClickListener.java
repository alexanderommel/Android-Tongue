package com.example.tongue.interfaces;

import android.view.View;

import com.example.tongue.models.Modifier;

public interface ModifierClickListener {
    public void onModifierClicked(Modifier modifier, View view, int position, Boolean uniquePick);
}
