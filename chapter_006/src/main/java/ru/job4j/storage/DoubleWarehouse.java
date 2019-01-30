package ru.job4j.storage;

/**
 * Special variation of warehouse. Working without pattern "Decorator".
 */
public class DoubleWarehouse extends Warehouse {
    private Warehouse warehouse;
    private int maxSize;

    public DoubleWarehouse(int maxSize) {
        this.warehouse = new Warehouse();
        this.maxSize = maxSize;
    }

    public void isFull() {
        if (this.getContainer().size() == maxSize) {
            this.warehouse.getContainer().add(this.getContainer().get(maxSize - 1));
            this.getContainer().remove(maxSize - 1);
        }
    }

    @Override
    public void checkContainer() {
        for (int i = 0; i < this.getContainer().size(); i++) {
            if (!this.getContainer().get(i).isToWareshop()) {
                this.getContainer().remove(i);
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
