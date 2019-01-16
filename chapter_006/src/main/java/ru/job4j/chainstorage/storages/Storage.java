package ru.job4j.chainstorage.storages;

import ru.job4j.chainstorage.Food;

import java.util.ArrayList;

/**
 * This class is collecting all goods and working with them.
 */
public abstract class Storage {
    /**
     * Special List for guard all goods.
     */
    private ArrayList<Food> goods = new ArrayList<>();

    /**
     * Method for organizate transportations of goods
     * @param goods
     * @return goods after modification
     */
    public ArrayList<Food> renovate(ArrayList<Food> goods) {
        this.goods = this.change(this.goods);
        goods = this.change(goods);
        this.addAll(goods);
        this.deleteIncompatible(goods);
        return goods;
    }

    /**
     * Method for delete incompatibles goods.
     * @param goods
     * @return goods after modification
     */
    public ArrayList<Food> deleteIncompatible(ArrayList<Food> goods) {
        for (int i = this.goods.size() - 1; i >= 0; i--) {
            if (!this.goods.get(i).isAdded()) {
                goods.add(this.goods.get(i));
                this.goods.remove(i);
            }
        }
        return goods;
    }

    /**
     * Special container modifications.
     * @param goods
     * @return goods after modification.
     */
    public abstract ArrayList<Food> change(ArrayList<Food> goods);

    /**
     * Method to add all new goods.
     * @param goods
     */
    public void addAll(ArrayList<Food> goods) {
        for (int i = 0; i < goods.size(); i++) {
            if (goods.get(i).isAdded()) {
                this.goods.add(goods.get(i));
            }
        }
    }

    /**
     * Method for returning goods of container.
     * @return
     */
    public ArrayList<Food> getGoods() {
        return goods;
    }

}
