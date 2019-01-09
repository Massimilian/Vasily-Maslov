package ru.job4j.storage;

import java.util.HashSet;
import java.util.Set;

/**
 * This is a shop class for actual goods.
 */
public class Shop extends Container {

    @Override
    public void checkContainer() {
        for (int i = 0; i < this.getContainer().size(); i++) {
            if (!this.getContainer().get(i).isToShop()) {
                this.getContainer().remove(i);
            }
        }
    }
}
