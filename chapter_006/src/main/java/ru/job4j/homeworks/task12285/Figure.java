package ru.job4j.homeworks.task12285;

public abstract class Figure {
    private char type;
    private int posX;
    private int posY;

    public Figure(int posX, int posY) {
        this.posX = posX;
        this.posY = posY;
    }

    public int getPosX() {
        return posX;
    }

    public int getPosY() {
        return posY;
    }

    public char getType() {
        return type;
    }

    public void setType(char type) {
        this.type = type;
    }

    public abstract char[][] getDanger(char[][] square);

    public char[][] getDangerByLines(char[][] square, int x, int y) {
        int countX = this.getPosX() + x;
        int countY = this.getPosY() + y;
        while (countX < square.length && countX >= 0 && countY < square.length && countY >= 0) {
            square[countX][countY] = '*';
            countX += x;
            countY += y;
        }
        return square;
    }
}
