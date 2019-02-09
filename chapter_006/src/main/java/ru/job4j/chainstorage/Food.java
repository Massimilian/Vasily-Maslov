package ru.job4j.chainstorage;

import java.util.Date;
import java.util.Objects;

/**
 * Special class of goods
 */
public class Food {
    private String name;
    private Date createDate;
    private Date expaireDate;
    private double price;
    private boolean discount;
    private boolean isAdded;
    private boolean canReproduct;
    private boolean isVegetable;

    public Food(String name, long createDate, long expaireDate, double price) {
        this.name = name;
        this.createDate = new Date(createDate);
        this.expaireDate = new Date(expaireDate);
        this.price = price;
        this.discount = false;
        this.isAdded = false;
    }

    public String getName() {
        return name;
    }

    public boolean isCanReproduct() {
        return canReproduct;
    }

    public void setCanReproduct(boolean canReproduct) {
        this.canReproduct = canReproduct;
    }

    public void setVegetable(boolean vegetable) {
        isVegetable = vegetable;
    }

    public boolean isVegetable() {
        return isVegetable;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public Date getExpaireDate() {
        return expaireDate;
    }

    public void setDiscount(boolean discount) {
        this.discount = discount;
    }

    public void setAdded(boolean added) {
        isAdded = added;
    }

    public boolean isAdded() {
        return isAdded;
    }
}