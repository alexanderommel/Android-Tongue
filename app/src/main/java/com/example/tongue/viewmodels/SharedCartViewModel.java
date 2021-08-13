package com.example.tongue.viewmodels;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.tongue.models.Cart;
import com.example.tongue.models.LineItem;

public class SharedCartViewModel extends ViewModel {

    private MutableLiveData<Cart> cart = new MutableLiveData<>();

    public void addItemToCart(LineItem item){
        Cart cart = new Cart();
        cart.addItem(item);
        this.cart.setValue(cart);
    }

    public LiveData<Cart> getCart(){
        return cart;
    }
}
