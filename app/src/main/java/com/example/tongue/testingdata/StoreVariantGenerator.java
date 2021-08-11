package com.example.tongue.testingdata;

import com.example.tongue.models.StoreVariant;

import java.util.ArrayList;
import java.util.List;

public class StoreVariantGenerator {

    public static List<StoreVariant> getStores(int size){
        List<StoreVariant> stores = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            StoreVariant storeVariant = new StoreVariant();
            storeVariant.setId(i);
            stores.add(storeVariant);
        }
        return stores;
    }
}
