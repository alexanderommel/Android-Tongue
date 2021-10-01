package com.example.tongue.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tongue.R;
import com.example.tongue.models.Cart;
import com.example.tongue.models.LineItem;

import org.jetbrains.annotations.NotNull;

import java.util.List;

public class CheckoutCartAdapter extends RecyclerView.Adapter<CheckoutCartAdapter.CheckoutCartViewHolder> {

    //Fields
    private List<LineItem> itemList;

    public CheckoutCartAdapter(Cart cart){
        itemList = cart.getItems();
    }

    @NonNull
    @NotNull
    @Override
    public CheckoutCartViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.checkout_car_item,parent,false);
        return new CheckoutCartViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull CheckoutCartViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }

    public class CheckoutCartViewHolder extends RecyclerView.ViewHolder {

        //Fields
        private TextView quantity;
        private TextView title;
        private TextView total;
        private TextView subtotal;

        public CheckoutCartViewHolder(@NonNull @NotNull View itemView) {
            super(itemView);
            quantity = itemView.findViewById(R.id.checkout_cart_item_quantity);
            title = itemView.findViewById(R.id.checkout_cart_item_title);
            total = itemView.findViewById(R.id.checkout_cart_item_total);
            subtotal = itemView.findViewById(R.id.checkout_cart_item_subtotal);
        }
    }
}
