package com.example.tongue.models;

import java.math.BigDecimal;

public class CheckoutPrice {

    private BigDecimal cartTotal;

    private BigDecimal cartSubtotal;

    private BigDecimal checkoutTotal;

    private BigDecimal checkoutSubtotal;

    public BigDecimal getCartTotal() {
        return cartTotal;
    }

    public void setCartTotal(BigDecimal cartTotal) {
        this.cartTotal = cartTotal;
    }

    public BigDecimal getCartSubtotal() {
        return cartSubtotal;
    }

    public void setCartSubtotal(BigDecimal cartSubtotal) {
        this.cartSubtotal = cartSubtotal;
    }

    public BigDecimal getCheckoutTotal() {
        return checkoutTotal;
    }

    public void setCheckoutTotal(BigDecimal checkoutTotal) {
        this.checkoutTotal = checkoutTotal;
    }

    public BigDecimal getCheckoutSubtotal() {
        return checkoutSubtotal;
    }

    public void setCheckoutSubtotal(BigDecimal checkoutSubtotal) {
        this.checkoutSubtotal = checkoutSubtotal;
    }
}
