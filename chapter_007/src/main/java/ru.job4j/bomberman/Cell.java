package ru.job4j.bomberman;

/**
 * The single cell of board.
 */
public class Cell {
    private int posX;
    private int posY;

    public Cell(int posX, int posY) {
        this.posX = posX;
        this.posY = posY;
    }

    public Cell(Cell cell) {
        this.posX = cell.getPosX();
        this.posY = cell.getPosY();
    }

    public int getPosX() {
        return posX;
    }

    public void setPosX(int posX) {
        this.posX = posX;
    }

    public int getPosY() {
        return posY;
    }

    public void setPosY(int posY) {
        this.posY = posY;
    }
}
