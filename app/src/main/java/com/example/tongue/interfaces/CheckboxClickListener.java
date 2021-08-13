package com.example.tongue.interfaces;

import android.view.View;

import com.example.tongue.models.Modifier;

public interface CheckboxClickListener {
    public void onCheckboxClicked(Modifier modifier, View view, int position);
}
