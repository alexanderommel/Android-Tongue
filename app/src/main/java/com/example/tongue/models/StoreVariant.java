package com.example.tongue.models;

import android.widget.ImageView;
import android.widget.TextView;

public class StoreVariant {
    private  long id;
    private ImageView storeImage;
    private TextView storeTitle;
    private TextView storeShippingPrice;
    private TextView storeDescription;

    public ImageView getStoreImage() {
        return storeImage;
    }

    public void setStoreImage(ImageView storeImage) {
        this.storeImage = storeImage;
    }

    public TextView getStoreTitle() {
        return storeTitle;
    }

    public void setStoreTitle(TextView storeTitle) {
        this.storeTitle = storeTitle;
    }

    public TextView getStoreShippingPrice() {
        return storeShippingPrice;
    }

    public void setStoreShippingPrice(TextView storeShippingPrice) {
        this.storeShippingPrice = storeShippingPrice;
    }

    public TextView getStoreDescription() {
        return storeDescription;
    }

    public void setStoreDescription(TextView storeDescription) {
        this.storeDescription = storeDescription;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
