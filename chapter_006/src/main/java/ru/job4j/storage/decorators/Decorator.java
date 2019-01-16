package ru.job4j.storage.decorators;

import ru.job4j.storage.BaseContainer;
import ru.job4j.storage.Food;

import java.util.ArrayList;

public abstract class Decorator implements BaseContainer {
    private BaseContainer bc;

    public Decorator(BaseContainer bc) {
        this.bc = bc;
    }

    public BaseContainer getBc() {
        return bc;
    }

    @Override
    public ArrayList<Food> getContainer() {
        return this.bc.array;
    }

    @Override
    public void checkContainer() {
        this.bc.checkContainer();
    }

    @Override
    public void renovContainer(Food food) {
        this.bc.renovContainer(food);
    }
}
