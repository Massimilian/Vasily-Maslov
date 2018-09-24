package ru.job4j.threads.bomberman;

import java.util.Random;

public class Creature {
    private Cell position = new Cell();

    public Creature(int posX, int posY) {
        this.position.setX(posX);
        this.position.setY(posY);
    }

    public Cell getPosition() {
        return position;
    }

    public void setPosition(Cell position) {
        this.position = position;
    }

    public Cell getNewPosition(int size) {
        Random random = new Random();
        Cell result = new Cell();
        if (random.nextBoolean()) {
            // рандомно выбираем - какой параметр менять (x или y)
            result.setX(movingAction(this.position.getX(), size, random));
            result.setY(this.position.getY());
        } else {
            result.setY(movingAction(this.position.getY(), size, random));
            result.setX(this.position.getX());
        }
        return result;
    }

    private int movingAction(int movable, int size, Random random) {
        boolean side = random.nextBoolean();
        // проверяем - не выбивается ли параметр за пределы размера борта, а затем вводим новые данные
        side = movable == 0 || side;
        side = movable != size - 1 && side;
        movable = side ? movable + 1 : movable - 1;
        return movable;
    }
}
