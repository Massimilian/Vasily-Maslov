package ru.job4j.chess;

import ru.job4j.chess.exceptions.*;

public class Cell {
    int posX;
    int posY;

    public Cell(int posX, int posY) throws ImpossibleCellException {
        if (posX > 8 || posY > 8 || posX < 1 || posY < 1) {
            throw new ImpossibleCellException("Can't make this cell!");
        } else {
            this.posX = posX;
            this.posY = posY;
        }
    }

    public Cell() {
    }

    public int getPosX() {
        return posX;
    }

    public int getPosY() {
        return posY;
    }

    public void setPosX(int posX) {
        this.posX = posX;
    }

    public void setPosY(int posY) {
        this.posY = posY;
    }
}