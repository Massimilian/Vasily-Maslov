package ru.job4j.homeworks.task12285;

public class Elefant extends Figure {
    public Elefant(int posX, int posY) {
        super(posX, posY);
        this.setType('E');
    }

    @Override
    public char[][] getDanger(char[][] square) {
        return getDangerByLines(getDangerByLines(getDangerByLines(getDangerByLines(square, 1, 1), -1, -1), -1, 1), 1, -1);
    }
}
