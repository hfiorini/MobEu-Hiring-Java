package com.mobiquityinc.model;

import java.math.BigDecimal;
import java.util.List;

public class TextLine {
    private BigDecimal maxWeight;
    private List<Item> items;

    public BigDecimal getMaxWeight() {
        return maxWeight;
    }

    public void setMaxWeight(BigDecimal maxWeight) {
        this.maxWeight = maxWeight;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }
}
