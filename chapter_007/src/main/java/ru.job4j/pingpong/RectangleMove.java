package ru.job4j.pingpong;

import javafx.scene.shape.Rectangle;

public class RectangleMove implements Runnable {
    private final Rectangle rect;
    int frame;
    int moveX = 1;
    int moveY = 1;

    public RectangleMove(Rectangle rect, int size) {
        this.rect = rect;
        this.frame = size - 10;
    }

    @Override
    public void run() {
        //while (!Thread.currentThread().isInterrupted()) { // этот вариант, я так понимаю, предполагался, как правильное решение. Тем не менее, если поток запущен в вечный цикл, всё равно код работает корректно (просто прерывается, и зачем ему тогда зависеть от флага?).
        while (true) {
            if (this.rect.getX() >= frame || this.rect.getX() <= 10) {
                moveX *= -1;
            } else if (this.rect.getY() >= frame || this.rect.getY() <= 10) {
                moveY *= -1;
            }
            this.rect.setX(this.rect.getX() + moveX);
            this.rect.setY(this.rect.getY() + moveY);
            try {
                Thread.sleep(40);
            } catch (InterruptedException e) {
                return;
            }
        }
    }
}
