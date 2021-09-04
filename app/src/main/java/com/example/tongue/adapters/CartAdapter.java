package com.example.tongue.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tongue.R;
import com.example.tongue.interfaces.CartClickListener;
import com.example.tongue.models.Cart;
import com.example.tongue.models.LineItem;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import org.jetbrains.annotations.NotNull;

public class CartAdapter extends RecyclerView.Adapter<CartAdapter.CartViewHolder> {

    private Cart cart;
    private CartClickListener listener;

    public CartAdapter(Cart cart, CartClickListener listener){
        this.cart=cart;
        this.listener=listener;
    }

    @NonNull
    @NotNull
    @Override
    public CartAdapter.CartViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cart_recyclerview_item,parent,false);
        return new CartViewHolder(view,viewType);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull CartAdapter.CartViewHolder holder, int position) {
        holder.productImage.setImageResource(R.drawable.japonesastore);
        holder.title.setText("Sushi Alex 6 de Diciembre");
        holder.quantity.setText("9");
    }

    @Override
    public int getItemCount() {
        return cart.getItems().size();
    }

    @Override
    public int getItemViewType(int position) {
        return position;
    }

    public class CartViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        //Fields
        private LineItem lineItem;
        private ImageView productImage;
        private TextView title;
        private TextView price;
        private TextView quantity;
        private FloatingActionButton reduceButton;
        private FloatingActionButton increaseButton;

        public CartViewHolder(@NonNull @NotNull View itemView, int position) {
            super(itemView);
            lineItem = cart.getItems().get(position);
            productImage = itemView.findViewById(R.id.cart_rv_item_productImage);
            title = itemView.findViewById(R.id.cart_rv_item_title);
            price = itemView.findViewById(R.id.cart_rv_item_price);
            quantity = itemView.findViewById(R.id.cart_rv_item_quantity);
            reduceButton = itemView.findViewById(R.id.cart_rv_item_reducebutton);
            increaseButton = itemView.findViewById(R.id.cart_rv_item_increase);
            reduceButton.setOnClickListener(this);
            increaseButton.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.cart_rv_item_increase:
                    listener.onIncrease(lineItem,price);
                    break;
                case R.id.cart_rv_item_reducebutton:
                    listener.onReduce(lineItem,price);
                    break;
                default:
                    break;
            }
        }
    }

}
