package ru.job4j.chainstorage.storages;

import ru.job4j.chainstorage.Food;

import java.util.ArrayList;
/**
 * Special Decorator (Storage) to keep vegetables.
 */
public class StorageForVegetables extends Decorator {

    public StorageForVegetables(Storage storage) {
        super(storage);
    }

    @Override
    public ArrayList<Food> afterRenovate() {
        ArrayList<Food> vegetables = new ArrayList<Food>();
        for (int i = this.storage.getGoods().size() - 1; i >= 0; i--) {
            if (this.storage.getGoods().get(i).isVegetable()) {
                vegetables.add(this.storage.getGoods().get(i));
                this.storage.getGoods().remove(i);
            }
        }
        this.setGoods(vegetables);
        return this.storage.getGoods();
    }

    @Override
    public ArrayList<Food> beforeRenovate() {
        return getGoods();
    }


    @Override
    public ArrayList<Food> change(ArrayList<Food> goods) {
        return null;
    }
}
