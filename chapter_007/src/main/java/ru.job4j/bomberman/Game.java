package ru.job4j.bomberman;

public class Game {
    private final int size;
    private final Board board;
    private final Creature bomberman;

    public Game(int size, int posX, int posY) {
        this.size = size;
        bomberman = new Heroe(posX, posY, size);
        board = new Board(size);
    }

    public Board getBoard() {
        return this.board;
    }

    public Creature getBomberman() {
        return this.bomberman;
    }
}
