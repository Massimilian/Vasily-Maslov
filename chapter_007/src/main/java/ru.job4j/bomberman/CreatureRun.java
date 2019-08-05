package ru.job4j.bomberman;

/**
 * Base class of creature run
 */
public abstract class CreatureRun implements Runnable {
    protected Board board;
    protected Creature creature;

    public CreatureRun(Creature creature, Board board) {
        this.creature = creature;
        this.board = board;
    }

    /**
     * Class to move the creature
     */
    protected abstract void go();
}
