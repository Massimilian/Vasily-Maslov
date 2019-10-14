package ru.job4j.homeworks.task12285;

public class Queen extends Figure {
    private Figure elefant;
    private Figure rook;

    public Queen(int posX, int posY) {
        super(posX, posY);
        this.elefant = new Elefant(posX, posY);
        this.rook = new Rook(posX, posY);
        this.setType('Q');
    }

    @Override
    public char[][] getDanger(char[][] square) {
        return this.rook.getDanger(this.elefant.getDanger(square));
    }
}
