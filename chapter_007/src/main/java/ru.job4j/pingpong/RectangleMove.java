package ru.job4j.pingpong;

import javafx.scene.shape.Rectangle;

public class RectangleMove implements Runnable {
    private final Rectangle rect;
    final int frame = 290;

    public RectangleMove(Rectangle rect) {
        this.rect = rect;
    }

    @Override
    public void run() {
        while (!Thread.currentThread().isInterrupted()) {
            int x = 1;
            int y = 1;
            if (this.rect.getX() >= frame || this.rect.getX() <= 10) {
                x *= -1;
            } else if (this.rect.getY() >= frame || this.rect.getY() <= 10) {
                y *= -1;
            }
            this.rect.setX(this.rect.getX() + x);
            this.rect.setY(this.rect.getY() + y);
            try {
                Thread.sleep(40);
            } catch (InterruptedException e) {
                System.out.println("Program finished.");
            }
        }
    }
}
