package ru.job4j.chainstorage;

import ru.job4j.chainstorage.storages.*;

import java.util.ArrayList;

/**
 * Special class for manage all Containers and goods.
 */
public class FoodManager {
    //    private Storage warehouse = new Warehouse();
    private Storage warehouse = new ExpandedWarehouse();
    private Storage shop = new Shop();
    private Storage trash = new Trash();
    private Decorator sfr = new StorageForReproduct(this.trash);
    private Decorator sfv = new StorageForVegetables(this.warehouse);
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

    public Decorator getSfr() {
        return sfr;
    }

    public Decorator getSfv() {
        return sfv;
    }

    /**
     * Special method for renovating the whole situation. May work without Decorators.
     */
    public void action() {
//      this.warehouse.renovate(this.goods);
        this.sfv.renovate(this.goods);
        this.cleanGoods();
        this.shop.renovate(this.goods);
        this.cleanGoods();
//      this.trash.renovate(this.goods);
        this.sfr.renovate(this.goods);
        this.cleanGoods();
    }

    /**
     * This Method is cleaning the List of goods.
     */
    private void cleanGoods() {
        for (int i = this.goods.size() - 1; i >= 0; i--) {
            if (this.goods.get(i).isAdded()) {
                this.goods.remove(i);
            }
        }
    }
}
