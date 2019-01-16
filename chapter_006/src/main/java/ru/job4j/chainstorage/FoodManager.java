package ru.job4j.chainstorage;

import ru.job4j.chainstorage.storages.*;

import java.util.ArrayList;

public class FoodManager {
    private Storage warehouse = new Warehouse();
    private Storage shop = new Shop();
    private Storage trash = new Trash();
    private ArrayList<Food> goods;

    public FoodManager(ArrayList<Food> goods) {
        this.goods = goods;
    }

    public Storage getWarehouse() {
        return warehouse;
    }

    public Storage getShop() {
        return shop;
    }

    public Storage getTrash() {
        return trash;
    }

    public void action() {
        this.warehouse.renovate(this.goods);
        this.cleanGoods();
        this.shop.renovate(this.goods);
        this.cleanGoods();
        this.trash.renovate(this.goods);
        this.cleanGoods();
    }

    private void cleanGoods() {
        for (int i = this.goods.size() - 1; i >= 0; i--) {
            if (this.goods.get(i).isAdded()) {
                this.goods.remove(i);
            }
        }
    }
}
