package com.example.tongue.fragments;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.tongue.adapters.CartAdapter;
import com.example.tongue.databinding.CartFragmentBinding;
import com.example.tongue.interfaces.CartClickListener;
import com.example.tongue.models.Cart;
import com.example.tongue.models.LineItem;
import com.example.tongue.models.Product;
import com.example.tongue.viewmodels.CartViewModel;

import org.jetbrains.annotations.NotNull;

public class CartFragment extends Fragment{

    //Fields
    private CartFragmentBinding binding;
    private CartViewModel viewModel;
    private OnCartDetailsListener listener;

    //Methods
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState){

        //Default settings
        viewModel =
                new ViewModelProvider(this).get(CartViewModel.class);

        binding = CartFragmentBinding.inflate(inflater,container,false);
        View root = binding.getRoot();

        // Cart recyclerview setting
        LinearLayoutManager manager = new LinearLayoutManager(getContext());
        Cart cart = new Cart();
        LineItem item = new LineItem();
        item.setQuantity(5);
        cart.addItem(item);
        item.setQuantity(11);
        cart.addItem(item);
        CartAdapter adapter = new CartAdapter(cart, new CartClickListener() {
            @Override
            public void onIncrease(LineItem lineItem, TextView subtotal) {
                System.out.println("TEST1");
            }
            @Override
            public void onReduce(LineItem lineItem, TextView subtotal) {
                System.out.println("TEST2");
            }
        });
        binding.cartFragmentRecyclerView.setLayoutManager(manager);
        binding.cartFragmentRecyclerView.setAdapter(adapter);


        binding.cartFragmentShippingdetails.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Temporal!!!
                listener.OnCartDetailsClicked(cart);
            }
        });



        return root;
    }

    @Override
    public void onAttach(@NonNull @NotNull Context context) {
        super.onAttach(context);
        try {
            listener = (OnCartDetailsListener) context;
        } catch (ClassCastException e){
            throw new ClassCastException(context.toString()+ "must implement OnCartDetailsListener");
        }
    }

    public interface OnCartDetailsListener {
        public void OnCartDetailsClicked(Cart cart);
    }


}
