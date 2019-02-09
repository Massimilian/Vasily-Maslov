package ru.job4j.chainstorage.storages;

import ru.job4j.chainstorage.Food;

import java.util.ArrayList;

public class Shop extends Storage {

    /**
     * Change with special conditions.
     * @param goods
     * @return
     */
    @Override
    public ArrayList<Food> change(ArrayList<Food> goods) {
        for (int i = 0; i < goods.size(); i++) {
            if ((goods.get(i).getExpaireDate().getTime() - goods.get(i).getCreateDate().getTime()) * 0.75
                    > goods.get(i).getExpaireDate().getTime() - System.currentTimeMillis()
                    && goods.get(i).getExpaireDate().getTime() - System.currentTimeMillis() > 0) {
                goods.get(i).setAdded(true);
            } else {
                goods.get(i).setAdded(false);
            }
        }
        this.makeDiscount();
        return goods;
    }

    /**
     * Make discount if it needs.
     */
    private void makeDiscount() {
        for (int i = 0; i < this.getGoods().size(); i++) {
            if ((this.getGoods().get(i).getExpaireDate().getTime() - this.getGoods().get(i).getCreateDate().getTime()) * 0.25
                    > this.getGoods().get(i).getExpaireDate().getTime() - System.currentTimeMillis()) {
                this.getGoods().get(i).setDiscount(true);
            }
        }
    }
}
