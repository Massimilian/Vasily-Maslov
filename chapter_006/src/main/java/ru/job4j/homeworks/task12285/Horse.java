package ru.job4j.homeworks.task12285;

public class Horse extends Figure {
    public Horse(int posX, int posY) {
        super(posX, posY);
        this.setType('H');
    }

    @Override
    public char[][] getDanger(char[][] square) {
        return getDangerByLines(getDangerByLines(getDangerByLines(getDangerByLines(getDangerByLines(getDangerByLines(getDangerByLines(getDangerByLines(square, 1, -2), -1, 2), -1, -2), 1, 2), -2, -1), -2, 1), 2, -1), 2, 1);
    }

    @Override
    public char[][] getDangerByLines(char[][] square, int x, int y) {
        int countX = this.getPosX() + x;
        int countY = this.getPosY() + y;
        if (countX < square.length && countX >= 0 && countY < square.length && countY >= 0) {
            square[countX][countY] = '*';
        }
        return square;
    }
}
