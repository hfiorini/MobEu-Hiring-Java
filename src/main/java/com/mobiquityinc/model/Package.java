package com.mobiquityinc.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Package {
    private BigDecimal maxWeight;
    private List<Item> items = new ArrayList<>();

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public BigDecimal getMaxWeight() {
        return maxWeight;
    }

    public void setMaxWeight(BigDecimal maxWeight) {
        this.maxWeight = maxWeight;
    }

    public BigDecimal totalWeight(){
        BigDecimal total = BigDecimal.ZERO;
        for (Item item: items) {
            total = total.add(item.getWeight());
        }
        return total;
    }

    public BigDecimal totalCost(){
        BigDecimal total = BigDecimal.ZERO;
        for (Item item: items) {
            total = total.add(item.getCost());
        }
        return total;
    }

    public String toString(){
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < items.size(); i++) {
            sb.append(items.get(i).getIndex());
            if (i != items.size() -1){
                sb.append(", ");
            }else{
                sb.append("\n");
            }
        }
        return sb.toString();
    }
}
