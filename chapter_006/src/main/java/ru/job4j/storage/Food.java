package ru.job4j.storage;

import java.util.Date;
import java.util.Objects;

/**
 * Special class of foods
 */
public class Food {
    private String name;
    private Date createDate;
    private Date expaireDate;
    private double price;
    private boolean discount;
    private boolean toWareshop;
    private boolean toShop;
    private boolean toGarbage;

    public Food(String name, long createDate, long expaireDate, double price) {
        this.name = name;
        this.createDate = new Date(createDate);
        this.expaireDate = new Date(expaireDate);
        this.price = price;
        this.discount = false;
        this.toWareshop = true;
        this.toShop = false;
        this.toGarbage = false;
    }

    public boolean isDiscount() {
        return discount;
    }

    public boolean isToWareshop() {
        return toWareshop;
    }

    public boolean isToGarbage() {
        return toGarbage;
    }

    public boolean isToShop() {
        return toShop;
    }

    /**
     * This method is nessesary for using collections of different goods.
     *
     * @param o
     * @return
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Food food = (Food) o;
        return Objects.equals(name, food.name) &&
                Objects.equals(createDate, food.createDate) &&
                Objects.equals(expaireDate, food.expaireDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, createDate, expaireDate);
    }

    /**
     * Special method for renovating information of goods.
     */
    public void renovPos() {
        long allTime = this.expaireDate.getTime() - this.createDate.getTime();
        if (0 >= this.expaireDate.getTime() - System.currentTimeMillis()) {
            this.toGarbage = true;
            this.toShop = false;
        } else if (allTime * 0.25 >= this.expaireDate.getTime() - System.currentTimeMillis()) {
            this.discount = true;
            this.toShop = true;
            this.toWareshop = false;
        } else if (allTime * 0.75 >= this.expaireDate.getTime() - System.currentTimeMillis()) {
            this.toShop = true;
            this.toWareshop = false;
        }
    }
}