package com.example.tongue.testingdata;

import com.example.tongue.models.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ProductGenerators {

    public static List<Product> getProducts(int size){
        Random random = new Random();
        Long id;
        List<Product> products = new ArrayList<>();
        for (int i=0; i<size; i++){
            Product product = new Product();
            id = Long.valueOf(random.nextInt());
            product.setId(id);
            products.add(product);
        }
        return products;
    }
}
