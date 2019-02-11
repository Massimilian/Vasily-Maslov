package ru.job4j.chainstorage.storages;

import ru.job4j.chainstorage.Food;

import java.util.ArrayList;

/**
 * Special class for using the pattern "Decorator"
 */
public abstract class Decorator extends Storage {
    Storage storage;

    public Decorator(Storage storage) {
        this.storage = storage;
    }

    public abstract ArrayList<Food> afterRenovate();

    public abstract ArrayList<Food> beforeRenovate();

    @Override
    public ArrayList<Food> renovate(ArrayList<Food> goods) {
        goods.addAll(beforeRenovate());
        ArrayList<Food> result = storage.renovate(goods);
        afterRenovate();
        return result;
    }
}
