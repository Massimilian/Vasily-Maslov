package ru.job4j.threads.bomberman;

import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {
        Board board = new Board(5, 0, 0);
        new Thread(() -> {
            while (true) {
                Cell oldPos = board.getHeroe().getPosition();
                Cell newPos = board.getHeroe().getNewPosition(board.getSize());
                if (!board.move(oldPos, newPos)) {
                    board.getHeroe().setPosition(oldPos);
                } else {
                    try {
                        TimeUnit.MILLISECONDS.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    board.getHeroe().setPosition(newPos);
                    System.out.println("New Bomberman position is " + board.getHeroe().printPosition(board.getHeroe().getPosition()));
                }
            }
        }).start();
    }
}
