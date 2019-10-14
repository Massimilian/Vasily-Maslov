package ru.job4j.bomberman;

import java.util.Random;

/**
 * The class of residents of Bestiarium.
 */
public class Bestia extends Creature {
    Random random = new Random();

    public Bestia(Board board, String name) {
        this.preparePosition(board);
        this.setName(name);
    }

    /**
     * Method to put bestias to different positions on the board
     *
     * @param board to put new Bestia on the board.
     */
    public void preparePosition(Board board) {
        Cell temp;
        do {
            temp = new Cell(random.nextInt(board.getBoardSize()), random.nextInt(board.getBoardSize()));
        } while ((temp.getPosX() == 0 && temp.getPosY() == 0) || board.getBoard()[temp.getPosX()][temp.getPosY()].isLocked());
        this.setCell(temp);
    }
}
