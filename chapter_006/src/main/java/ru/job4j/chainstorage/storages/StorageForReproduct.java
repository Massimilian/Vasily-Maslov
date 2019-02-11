package ru.job4j.chainstorage.storages;

import ru.job4j.chainstorage.Food;

import java.util.ArrayList;

/**
 * Special Decorator (Storage) to keep goods for reproduct.
 */
public class StorageForReproduct extends Decorator {

    public StorageForReproduct(Storage storage) {
        super(storage);
    }

    @Override
    public ArrayList<Food> afterRenovate() {
        ArrayList<Food> forReproduct = new ArrayList<Food>();
        for (int i = this.storage.getGoods().size() - 1; i >= 0; i--) {
            if (this.storage.getGoods().get(i).isCanReproduct()) {
                forReproduct.add(this.storage.getGoods().get(i));
                this.storage.getGoods().remove(i);
            }
        }
        this.setGoods(forReproduct);
        return this.storage.getGoods();
    }

    @Override
    public ArrayList<Food> beforeRenovate() {
        return new ArrayList<Food>();
    }

    @Override
    public ArrayList<Food> change(ArrayList<Food> goods) {
        return null;
    }
}
