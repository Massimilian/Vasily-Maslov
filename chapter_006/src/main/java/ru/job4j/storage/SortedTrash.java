package ru.job4j.storage;

import java.util.ArrayList;

/**
 * Special variation of warehouse. Working without pattern "Decorator".
 */
public class SortedTrash extends Trash {
    private ArrayList<Food> reproductTrash = new ArrayList<>();
    private ArrayList<Food> vegetables = new ArrayList<>();

    @Override
    public void renovContainer(Food food) {
        if (food.isCanReproduct()) {
            this.reproductTrash = this.deepSort(food, this.reproductTrash);
        } else if (food.isVegetable()) {
            this.vegetables = this.deepSort(food, this.vegetables);
        } else {
            super.renovContainer(food);
        }
    }

    private ArrayList<Food> deepSort(Food food, ArrayList<Food> container) {
        if (!container.contains(food)) {
            container.add(food);
        } else {
            container.set(container.indexOf(food), food);
        }
        return container;
    }
}
