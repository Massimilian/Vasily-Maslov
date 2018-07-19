package ru.job4j.threads.pingpong;

import javafx.scene.shape.Rectangle;

public class RectangleMove implements Runnable {
    private final Rectangle rect;
    private final int wallX;
    private int countX = 1;

    public RectangleMove(Rectangle rect, int x) {
        this.rect = rect;
        this.wallX = x;
    }

    @Override
    public void run() {
        while (true) {
            this.rect.setX(this.rect.getX() + countX);
            if (this.rect.getX() >= this.wallX - countX + 1 || this.rect.getX() <= 10 ) {
                countX = -countX;
            }
            try {
                Thread.sleep(40);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
