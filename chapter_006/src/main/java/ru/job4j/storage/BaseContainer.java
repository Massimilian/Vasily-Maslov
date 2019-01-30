package ru.job4j.storage;

import java.util.ArrayList;

public interface BaseContainer {

    /**
     * Special container for goods.
     */
    ArrayList<Food> FOODS = new ArrayList<>();

    ArrayList<Food> getContainer();

    /**
     * Special method for correcting the containers.
     */
    void checkContainer();

    /**
     * Special method for updating the containers.
     */
    void renovContainer(Food food);
}
