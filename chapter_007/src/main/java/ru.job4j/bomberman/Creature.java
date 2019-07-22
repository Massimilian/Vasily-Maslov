package ru.job4j.bomberman;

import java.util.Random;

public abstract class Creature {
    private String name;
    private Random cross = new Random();
    private Random destiny = new Random();
    private Cell cell;
    private final int maxPos;

    public Creature(int posX, int posY, int maxPos) {
        cell = new Cell(posX, posY);
        this.maxPos = maxPos;
    }

    public Cell getCell() {
        return cell;
    }

    public String getName() {
        return name;
    }

    public void setCell(Cell cell) {
        this.cell = cell;
    }

    public void move() {
        boolean madeChoise = false;
        while (!madeChoise) {
            madeChoise = true;
            if (cross.nextBoolean() && destiny.nextBoolean() && this.cell.getPosX() < this.maxPos - 1) {
                this.cell.setPosX(this.cell.getPosX() + 1);
            } else if (cross.nextBoolean() && !destiny.nextBoolean() && this.cell.getPosX() > 0) {
                this.cell.setPosX(this.cell.getPosX() - 1);
            } else if (!cross.nextBoolean() && destiny.nextBoolean() && this.cell.getPosY() < this.maxPos - 1) {
                this.cell.setPosY(this.cell.getPosY() + 1);
            } else if (!cross.nextBoolean() && !destiny.nextBoolean() && this.cell.getPosY() > 0) {
                this.cell.setPosY(this.cell.getPosY() - 1);
            } else {
                madeChoise = false;
            }
        }
    }
}
