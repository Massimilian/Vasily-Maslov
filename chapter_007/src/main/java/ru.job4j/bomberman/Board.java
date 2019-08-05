package ru.job4j.bomberman;

import java.util.concurrent.locks.ReentrantLock;

/**
 * Class of game place and static objects on it.
 */
public class Board {
    private final int boardSize;
    private ReentrantLock[][] board;
    private Stone[] stones;

    public Board(int size, int numbOfStones) {
        this.boardSize = size;
        board = new ReentrantLock[size][size];
        for (int i = 0; i < boardSize; i++) {
            for (int j = 0; j < boardSize; j++) {
                board[i][j] = new ReentrantLock();
            }
        }
        stones = new Stone[numbOfStones];
        for (int i = 0; i < numbOfStones; i++) {
            stones[i] = new Stone(this);
            this.reserved(stones[i].getCell());
        }
    }

    public int getBoardSize() {
        return boardSize;
    }

    public Stone[] getStones() {
        return stones;
    }

    /**
     * Method for blocking cells
     *
     * @param cell to block
     * @return blocked or no
     */
    public boolean tryCell(Cell cell) {
        return this.board[cell.getPosX()][cell.getPosY()].tryLock();
    }

    /**
     * Method to reserve the cell
     *
     * @param cell
     */
    public void reserved(Cell cell) {
        this.board[cell.getPosX()][cell.getPosY()].lock();
    }

    public ReentrantLock[][] getBoard() {
        return board;
    }
}
