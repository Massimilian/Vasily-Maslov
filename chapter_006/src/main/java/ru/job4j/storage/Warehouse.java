package ru.job4j.storage;

import java.util.HashSet;
import java.util.Set;

/**
 * This is a warehouse class for the best goods.
 */
public class Warehouse extends Container {

    @Override
    public void checkContainer() {
        for (int i = 0; i < this.getContainer().size(); i++) {
            if (!this.getContainer().get(i).isToWareshop()) {
                this.getContainer().remove(i);
            }
        }
    }
}
