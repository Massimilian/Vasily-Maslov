package ru.job4j.threads.bomberman;

import java.util.concurrent.TimeUnit;

public class BeastieAction implements Runnable {
    private String ls = System.lineSeparator();
    private int pos;
    private int speed;
    private Board board;

    public BeastieAction(int pos, Board board, int speed) {
        this.pos = pos;
        this.board = board;
        this.speed = speed * 10;
    }

    @Override
    public void run() {
        while (true) {
            Cell oldPos = board.getBeastie(pos).getPosition();
            Cell newPos = board.getBeastie(pos).getNewPosition(board.getSize());
            if (!board.move(oldPos, newPos)) {
                try {
                    System.out.printf("The Beastie number %d was very surprised...%s", pos, ls);
                    TimeUnit.MILLISECONDS.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                board.getBeastie(pos).setPosition(oldPos);
            } else {
                try {
                    TimeUnit.MILLISECONDS.sleep(1000 - this.speed);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                board.getBeastie(pos).setPosition(newPos);
                System.out.printf("New position of Beastie number %d is %s.%s", pos, board.getBeastie(pos).printPosition(board.getBeastie(pos).getPosition()), ls);
            }
        }
    }
}
