package ru.job4j.storage.decorators;

import ru.job4j.storage.BaseContainer;
import ru.job4j.storage.Food;
import java.util.ArrayList;

public class SortedTrashContainer extends Decorator {
    private ArrayList<Food> reproductTrash = new ArrayList<>();
    private ArrayList<Food> vegetables = new ArrayList<>();

    public SortedTrashContainer(BaseContainer bc) {
        super(bc);
    }

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
