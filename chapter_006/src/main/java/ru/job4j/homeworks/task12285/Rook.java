package ru.job4j.homeworks.task12285;

public class Rook extends Figure {
    public Rook(int posX, int posY) {
        super(posX, posY);
        this.setType('R');
    }

    @Override
    public char[][] getDanger(char[][] square) {
        return getDangerByLines(getDangerByLines(getDangerByLines(getDangerByLines(square, 1, 0), -1, 0), 0, 1), 0, -1);
    }
}
