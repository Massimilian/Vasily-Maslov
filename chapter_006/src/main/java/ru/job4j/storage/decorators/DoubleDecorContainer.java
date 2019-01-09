package ru.job4j.storage.decorators;

import ru.job4j.storage.BaseContainer;
import ru.job4j.storage.Food;
import ru.job4j.storage.Warehouse;

public class DoubleDecorContainer extends Decorator {

    private BaseContainer warehouse;
    private int maxSize;

    public DoubleDecorContainer(BaseContainer baseContainer, int maxSize) {
        super(baseContainer);
        this.warehouse = new StandartDecorContainer(new Warehouse());
        this.maxSize = maxSize;
    }

    public void isFull() {
        if (this.getBc().getContainer().size() == maxSize) {
            this.warehouse.getContainer().add(this.getBc().getContainer().get(maxSize - 1));
            this.getBc().getContainer().remove(maxSize - 1);
        }
    }

    @Override
    public void checkContainer() {
        for (int i = 0; i < this.getBc().getContainer().size(); i++) {
            if (!this.getBc().getContainer().get(i).isToWareshop()) {
                this.getBc().getContainer().remove(i);
            }
        }
        this.warehouse.checkContainer();
    }

    @Override
    public void renovContainer(Food food) {
        super.renovContainer(food);
        this.isFull();
    }
}
