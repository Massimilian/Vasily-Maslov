package ru.job4j.storage;

import sun.util.calendar.BaseCalendar;

import java.util.ArrayList;

/**
 * This class is for different types of containers.
 */
public abstract class Container implements BaseContainer {

    private ArrayList<Food> container = new ArrayList<>();

    public ArrayList<Food> getContainer() {
        return this.container;
    }

    /**
     * Special method for correcting the containers.
     */
    public void checkContainer() {
    }

    public void renovContainer(Food food) {
        if (!this.getContainer().contains(food)) {
            this.getContainer().add(food);
        } else {
            this.getContainer().set(this.getContainer().indexOf(food), food);
        }
    }
}
