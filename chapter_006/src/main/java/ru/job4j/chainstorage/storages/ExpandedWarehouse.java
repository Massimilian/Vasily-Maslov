package ru.job4j.chainstorage.storages;

import ru.job4j.chainstorage.Food;

import java.util.ArrayList;

/**
 * Special class for working with limited warehouse, but unlimited number of containers.
 */
public class ExpandedWarehouse extends Warehouse {
    private ExpandedWarehouse ew;
    //  This value may be different (as the customer wish)
    int size = 1;

    @Override
    public ArrayList<Food> renovate(ArrayList<Food> goods) {
        this.change(this.getGoods());
        goods = super.change(goods);
        this.addAll(goods);
        this.deleteIncompatible(goods);
        clean();
        return goods;
    }


    @Override
    public void addAll(ArrayList<Food> goods) {
        for (int i = 0; i < goods.size(); i++) {
            if (goods.get(i).isAdded()) {
                this.adding(goods.get(i));
            }
        }
    }

    @Override
    public ArrayList<Food> deleteIncompatible(ArrayList<Food> goods) {
        if (ew != null) {
            ew.deleteIncompatible(goods);
        }
        for (int i = this.getOneGood().size() - 1; i >= 0; i--) {
            if (!this.getOneGood().get(i).isAdded()) {
                goods.add(this.getOneGood().get(i));
                this.getOneGood().remove(i);
            }
        }
        return goods;
    }

    /**
     * Method to clean and delete and renovate this system of containers (elimination of "holes").
     */
    private void clean() {
        ArrayList<Food> tempList = this.getGoods();
        this.ew = null;
        this.setGoods(new ArrayList<Food>());
        this.addAll(tempList);
    }

    /**
     * New special method to add new Food.
     *
     * @param food
     */
    private void adding(Food food) {
        if (this.getOneGood().size() > this.size - 1) {
            if (this.ew == null) {
                this.ew = new ExpandedWarehouse();
            }
            ew.adding(food);
        } else {
            this.getOneGood().add(food);
        }
    }

    @Override
    public void setGoods(ArrayList<Food> goods) {
        super.setGoods(new ArrayList<Food>());
        for (int i = 0; i < goods.size(); i++) {
            this.adding(goods.get(i));
        }
    }

    @Override
    public ArrayList<Food> getGoods() {
        return putIn(new ArrayList<Food>(), this);
    }

    /**
     * Method to make the List of Foods.
     *
     * @param result
     * @param ew
     * @return
     */
    private ArrayList<Food> putIn(ArrayList<Food> result, ExpandedWarehouse ew) {
        if (ew.ew != null) {
            putIn(result, ew.ew);
        }
        for (int i = 0; i < ew.getOneGood().size(); i++) {
            result.add(ew.getOneGood().get(i));
        }
        return result;
    }

    /**
     * Special method for working with only this container with goods.
     *
     * @return this goods container (parent method)
     */
    private ArrayList<Food> getOneGood() {
        return super.getGoods();
    }

    public void setSize(int size) {
        this.size = size;
    }
}
