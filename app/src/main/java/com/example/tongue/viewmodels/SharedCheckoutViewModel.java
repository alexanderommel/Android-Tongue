package com.example.tongue.viewmodels;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.tongue.models.Cart;
import com.example.tongue.models.Checkout;

public class SharedCheckoutViewModel extends ViewModel {

    private MutableLiveData<Checkout> checkout = new MutableLiveData<>();

    public void addCartToCheckout(Cart cart){
        Checkout checkout = new Checkout();
        checkout.setCart(cart);
        this.checkout.setValue(checkout);
    }

    public LiveData<Checkout> getCheckout(){return checkout; }


}
