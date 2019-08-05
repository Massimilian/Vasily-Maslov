package ru.job4j.bomberman;

import java.util.Random;

/**
 * Basic class of creatures (objects) on the board
 */
public abstract class Creature {
    private String name;
    private Random cross = new Random();
    private Random destiny = new Random();
    private Cell cell;
    private boolean isEaten = false;

    public Creature(int posX, int posY, String name) {
        this.cell = new Cell(posX, posY);
        this.name = name;
    }

    public Creature() {
    }

    public Cell getCell() {
        return cell;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCell(Cell cell) {
        this.cell = cell;
    }

    public boolean isEaten() {
        return isEaten;
    }

    public void setEaten(boolean eaten) {
        isEaten = eaten;
    }

    /**
     * Method of creature's move.
     */
    public void move(int pos, Stone[] stones) {
        boolean madeChoise = false;
        Cell temp = new Cell(this.cell.getPosX(), this.cell.getPosY());
        while (!madeChoise) {
            madeChoise = true;
            if (cross.nextBoolean() && destiny.nextBoolean() && this.cell.getPosX() < pos - 1) {
                temp.setPosX(this.cell.getPosX() + 1);
            } else if (cross.nextBoolean() && !destiny.nextBoolean() && this.cell.getPosX() > 0) {
                temp.setPosX(this.cell.getPosX() - 1);
            } else if (!cross.nextBoolean() && destiny.nextBoolean() && this.cell.getPosY() < pos - 1) {
                temp.setPosY(this.cell.getPosY() + 1);
            } else if (!cross.nextBoolean() && !destiny.nextBoolean() && this.cell.getPosY() > 0) {
                temp.setPosY(this.cell.getPosY() - 1);
            } else {
                madeChoise = false;
            }
            if (madeChoise) { // we can't move on "stoned cells". Check it.
                for (int i = 0; i < stones.length; i++) {
                    madeChoise = isNotStoned(temp, stones[i]);
                    if (!madeChoise) {
                        break;
                    }
                }
            }
        }
        this.setCell(temp);
    }

    /**
     * Method to check the cell is it stoned or no
     *
     * @param cell  to check
     * @param stone to check
     * @return are equal (and stoned) or no
     */
    private boolean isNotStoned(Cell cell, Stone stone) {
        return !(cell.getPosX() == stone.getCell().getPosX() && cell.getPosY() == stone.getCell().getPosY());
    }
}
