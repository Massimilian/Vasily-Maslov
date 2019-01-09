package ru.job4j.storage;

import ru.job4j.storage.decorators.DoubleDecorContainer;
import ru.job4j.storage.decorators.SortedTrashContainer;
import ru.job4j.storage.decorators.StandartDecorContainer;

import java.util.ArrayList;

/**
 * This class is for keeping and dividing the goods.
 */
public class MainCheck {
    private ArrayList<Food> food = new ArrayList<>();
    private DoubleDecorContainer warehouse = new DoubleDecorContainer(new Warehouse(), 6);
    //private Container warehouse = new DoubleWarehouse(6);
    //private Container warehouse = new Warehouse;
    //private Shop shop = new Shop();
    private StandartDecorContainer shop = new StandartDecorContainer(new Shop());
    //private StandartDecorContainer shop = new StandartDecorContainer(new Shop());
    //private Container trash = new Trash();
    private SortedTrashContainer trash = new SortedTrashContainer(new Trash());
    //private Container trash = new SortedTrash();

    /**
     * Not-using methods - for possible future.
     *
     * @param food
     */
    public void getNewFood(Food food) {
        this.food.add(food);
    }

    public ArrayList<Food> getFood() {
        return this.food;
    }

    public BaseContainer getWarehouse() {
        return this.warehouse.getBc();
    }

//    public Container getWarehouse() {
//        return this.warehouse;
//    }

//    public Shop getShop() {
//        return shop;
//    }

    public BaseContainer getShop() {
        return this.shop.getBc();
    }

//    public Container getTrash() {
//        return this.trash;
//    }

    public BaseContainer getTrash() {
        return this.trash.getBc();
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
                this.trash.renovContainer(food);
                this.warehouse.checkContainer();
                this.shop.checkContainer();
            } else if (food.isDiscount() || food.isToShop()) {
                this.shop.renovContainer(food);
                this.warehouse.checkContainer();
            } else {
                this.warehouse.renovContainer(food);
            }
        }
    }
}
