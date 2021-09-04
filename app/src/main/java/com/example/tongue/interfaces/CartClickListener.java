package com.example.tongue.interfaces;

import android.view.View;
import android.widget.TextView;

import com.example.tongue.models.LineItem;

public interface CartClickListener {
    public void onIncrease(LineItem lineItem, TextView subtotal);
    public void onReduce(LineItem lineItem, TextView subtotal);
}
