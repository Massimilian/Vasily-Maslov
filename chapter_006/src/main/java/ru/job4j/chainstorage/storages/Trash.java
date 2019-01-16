package ru.job4j.chainstorage.storages;

import ru.job4j.chainstorage.Food;

import java.util.ArrayList;

public class Trash extends Storage {

    /**
     * Change with special conditions.
     * @param goods
     * @return
     */
    @Override
    public ArrayList<Food> change(ArrayList<Food> goods) {
        for (int i = 0; i < goods.size(); i++) {
            if (goods.get(i).getExpaireDate().getTime() - System.currentTimeMillis() <= 0) {
                goods.get(i).setAdded(true);
            }
        }
        return goods;
    }
}
