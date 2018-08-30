package ru.job4j.threads.bomberman;

import java.util.concurrent.locks.ReentrantLock;

public class Board {
    //  1. Есть игровое поле Board. Представляющее из себя массив ReentrantLock[][] board.
    final private ReentrantLock[][] board;
    final private int size;
    private Heroe heroe;

    public Heroe getHeroe() {
        return heroe;
    }

    public int getSize() {
        return size;
    }

    public Board(int size, int startPosX, int startPosY) {
        heroe = new Heroe(startPosX, startPosY);
        this.size = size;
        board = new ReentrantLock[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                board[i][j] = new ReentrantLock();
            }
        }
    }

    private void toLock(Cell cell) {
        board[cell.getX()][cell.getY()].lock();
    }

    private void toUnlock(Cell cell) {
        board[cell.getX()][cell.getY()].unlock();
    }

    private boolean isLocked(Cell cell) {
        return board[cell.getX()][cell.getY()].isLocked();
    }

    public boolean move(Cell source, Cell dist) {
        boolean result = false;
        if (!this.isLocked(dist)) {
            if (this.isLocked(source)) {
                this.toUnlock(source);
            }
            this.toLock(dist);
            result = true;
        }
        return result;
    }
}