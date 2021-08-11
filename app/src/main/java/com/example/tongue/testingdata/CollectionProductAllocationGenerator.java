package com.example.tongue.testingdata;

import com.example.tongue.models.Collection;
import com.example.tongue.models.CollectionProductAllocation;
import com.example.tongue.models.Product;

import java.util.ArrayList;
import java.util.List;

public class CollectionProductAllocationGenerator {

    public static List<CollectionProductAllocation> getProductAllocations(int size,String title){
        Collection collection = new Collection();
        collection.setTitle(title);
        List<Product> products = ProductGenerators.getProducts(size);
        List<CollectionProductAllocation> allocations = new ArrayList<>();
        for (int i=0;i<size;i++){
            Product product = products.get(i);
            CollectionProductAllocation allocation = new CollectionProductAllocation();
            allocation.setCollection(collection);
            allocation.setProduct(product);
            allocations.add(allocation);
        }

        return allocations;
    }

    public static List<List<CollectionProductAllocation>>
    getProductAllocationsList(String[] titles, int collectionsSize){

        List<List<CollectionProductAllocation>> list = new ArrayList<>();
        for (String title: titles) {
            List<CollectionProductAllocation> allocations =
                    getProductAllocations(collectionsSize,title);
            list.add(allocations);
        }
        return list;
    }
}
