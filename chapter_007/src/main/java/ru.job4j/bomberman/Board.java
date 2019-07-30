package ru.job4j.bomberman;

import java.util.concurrent.locks.ReentrantLock;

public class Board {
    private final int boardSize;
    private ReentrantLock[][] board;

    public Board(int size) {
        board = new ReentrantLock[size][size];
        this.boardSize = size;
        for (int i = 0; i < boardSize; i++) {
            for (int j = 0; j < boardSize; j++) {
                board[i][j] = new ReentrantLock();
            }
        }
    }

    public boolean tryCell(Cell cell) {
        return this.board[cell.getPosX()][cell.getPosY()].tryLock();
    }

    public void setCreature(Cell cell) {
        this.board[cell.getPosX()][cell.getPosY()].lock();
    }

    public ReentrantLock[][] getBoard() {
        return board;
    }
}
