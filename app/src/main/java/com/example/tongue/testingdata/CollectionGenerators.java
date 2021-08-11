package com.example.tongue.testingdata;

import com.example.tongue.models.Collection;
import com.example.tongue.models.CollectionProductAllocation;

import java.util.ArrayList;
import java.util.List;

public class CollectionGenerators {

    public static List<Collection>
    getCollections(String[] titles){

        List<Collection> collections = new ArrayList<>();
        for (String title: titles) {
            Collection collection = new Collection();
            collection.setId(1L);
            collection.setTitle(title);
            collections.add(collection);
        }
        return collections;
    }


}
