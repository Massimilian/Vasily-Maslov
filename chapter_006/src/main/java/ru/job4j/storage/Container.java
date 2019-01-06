package ru.job4j.storage;

import java.util.ArrayList;

/**
 * This class is for different types of containers.
 */
public abstract class Container {
    private ArrayList<Food> container = new ArrayList<>();

    public ArrayList<Food> getContainer() {
        return container;
    }
}
