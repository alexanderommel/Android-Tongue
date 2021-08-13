package com.example.tongue.models;

import java.util.ArrayList;
import java.util.List;

public class Cart {

    private Long id;

    private List<LineItem> items = new ArrayList<>();

    private String instruction;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<LineItem> getItems() {
        return items;
    }

    public void setItems(List<LineItem> items) {
        this.items = items;
    }

    public String getInstruction() {
        return instruction;
    }

    public void setInstruction(String instruction) {
        this.instruction = instruction;
    }

    public void addItem(LineItem item){
        items.add(item);
    }

}
