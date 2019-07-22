package ru.job4j.bomberman;

public abstract class CreatureRun implements Runnable {
    protected Board board;
    protected Creature creature;

    public CreatureRun(Creature creature, Board board) {
        this.creature = creature;
        this.board = board;
    }
}
