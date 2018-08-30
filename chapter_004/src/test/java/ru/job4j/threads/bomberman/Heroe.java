package ru.job4j.threads.bomberman;

import java.util.Random;

public class Heroe {
    private Cell position = new Cell();

    public Heroe(int posX, int posY) {
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
            result.setX(movingAction(position.getX(), size, random));
            result.setY(position.getY());
        } else {
            result.setY(movingAction(position.getY(), size, random));
            result.setX(position.getX());
        }
        return result;
    }

    private int movingAction(int movable, int size, Random random) {
        boolean side = random.nextBoolean();
        side = movable == 0 || side;
        side = movable != size - 1 && side;
        movable = side ? movable + 1 : movable - 1;
        return movable;
    }

    public String printPosition(Cell cell) {
        return cell.getX() + " " + cell.getY();
    }
}
