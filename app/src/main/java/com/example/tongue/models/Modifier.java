package com.example.tongue.models;

import java.math.BigDecimal;

public class Modifier {

    private Long id;
    private String name;
    private GroupModifier groupModifier;
    private BigDecimal price;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public GroupModifier getGroupModifier() {
        return groupModifier;
    }

    public void setGroupModifier(GroupModifier groupModifier) {
        this.groupModifier = groupModifier;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}
