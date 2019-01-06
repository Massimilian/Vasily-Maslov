package ru.job4j.storage;

import java.util.ArrayList;

/**
 * This class is for keeping and dividing the goods.
 */
public class MainCheck {
    private ArrayList<Food> food = new ArrayList<>();
    private Container warehouse = new Warehouse();
    private Container shop = new Shop();
    private Container trash = new Trash();

    public void getNewFood(Food food) {
        this.food.add(food);
    }

    public ArrayList<Food> getFood() {
        return this.food;
    }

    public Container getWarehouse() {
        return this.warehouse;
    }

    public Container getShop() {
        return this.shop;
    }

    public Container getTrash() {
        return this.trash;
    }

    /**
     * Main method for checking all foods.
     *
     * @param foodCourt
     */
    public void checkFoods(ArrayList<Food> foodCourt) {
        for (Food food : foodCourt) {
            food.renovPos();
            if (food.isToGarbage()) {
                renovTrash(food);
                checkWarehouse();
                checkShop();
            } else if (food.isDiscount() || food.isToShop()) {
                renovShop(food);
                checkWarehouse();
            } else {
                renovWarehouse(food);
            }
        }
    }

    /**
     * Special method for correcting the warehouse.
     */
    private void checkWarehouse() {
        for (int i = 0; i < warehouse.getContainer().size(); i++) {
            if (!warehouse.getContainer().get(i).isToWareshop()) {
                warehouse.getContainer().remove(i);
            }
        }
    }

    /**
     * Special method for correcting the shop.
     */
    private void checkShop() {
        for (int i = 0; i < shop.getContainer().size(); i++) {
            if (!shop.getContainer().get(i).isToShop()) {
                shop.getContainer().remove(i);
            }
        }
    }

    /**
     * Special method for updating the warehouse.
     */
    private void renovWarehouse(Food food) {
        if (!this.warehouse.getContainer().contains(food)) {
            this.warehouse.getContainer().add(food);
        } else {
            this.warehouse.getContainer().set(this.warehouse.getContainer().indexOf(food), food);
        }
    }

    /**
     * Special method for updating the shop.
     */
    private void renovShop(Food food) {
        if (!this.shop.getContainer().contains(food)) {
            this.shop.getContainer().add(food);
        } else {
            this.shop.getContainer().set(this.shop.getContainer().indexOf(food), food);
        }
    }

    /**
     * Special method for updating the trash.
     */
    private void renovTrash(Food food) {
        if (!this.trash.getContainer().contains(food)) {
            this.trash.getContainer().add(food);
        } else {
            this.trash.getContainer().set(this.trash.getContainer().indexOf(food), food);
        }
    }
}
