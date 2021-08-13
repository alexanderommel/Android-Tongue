package com.example.tongue.models;

public class GroupModifier {

    private Long id;

    private Product product;

    private StoreVariant storeVariant;

    private String type;

    private String context;

    private int maximumActiveModifiers=1;

    private int minimumActiveModifiers=0;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public StoreVariant getStoreVariant() {
        return storeVariant;
    }

    public void setStoreVariant(StoreVariant storeVariant) {
        this.storeVariant = storeVariant;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }

    public int getMaximumActiveModifiers() {
        return maximumActiveModifiers;
    }

    public void setMaximumActiveModifiers(int maximumActiveModifiers) {
        this.maximumActiveModifiers = maximumActiveModifiers;
    }

    public int getMinimumActiveModifiers() {
        if (type!=null){
            if (type.equalsIgnoreCase("mandatory") && minimumActiveModifiers==0)
                return 1;
        }
        return minimumActiveModifiers;
    }

    public void setMinimumActiveModifiers(int minimumActiveModifiers) {
        this.minimumActiveModifiers = minimumActiveModifiers;
    }
}
