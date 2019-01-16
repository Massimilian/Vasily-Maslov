package ru.job4j.chainstorage.storages;

import ru.job4j.chainstorage.Food;

import java.util.ArrayList;

public abstract class Storage {
    private ArrayList<Food> goods = new ArrayList<>();

    public ArrayList<Food> renovate(ArrayList<Food> goods) {
        this.goods = this.change(this.goods);
        goods = this.change(goods);
        this.addAll(goods);
        this.deleteIncompatible(goods);
        return goods;
    }

    public ArrayList<Food> deleteIncompatible(ArrayList<Food> goods) {
        for (int i = this.goods.size() - 1; i >= 0; i--) {
            if (!this.goods.get(i).isAdded()) {
                goods.add(this.goods.get(i));
                this.goods.remove(i);
            }
        }
        return goods;
    }

    public abstract ArrayList<Food> change(ArrayList<Food> goods);

    public void addAll(ArrayList<Food> goods) {
        for (int i = 0; i < goods.size(); i++) {
            if (goods.get(i).isAdded()) {
                this.goods.add(goods.get(i));
            }
        }
    }

    public ArrayList<Food> getGoods() {
        return goods;
    }

}
