package ru.job4j.chainstorage;

import java.util.ArrayList;

public class ControlQuality {
    private FoodManager fm;

    public ControlQuality(ArrayList<Food> goods) {
        this.fm = new FoodManager(goods);
    }

    public FoodManager getFm() {
        return fm;
    }

    public void resort() {
        fm.action();
    }

    public ArrayList<Food> getGoods() {
        ArrayList<Food> goods = new ArrayList<>();
        goods.addAll(fm.getWarehouse().getGoods());
        goods.addAll(fm.getShop().getGoods());
        goods.addAll(fm.getShop().getGoods());
        return goods;
    }
}
