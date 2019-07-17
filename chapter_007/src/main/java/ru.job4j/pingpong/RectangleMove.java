package ru.job4j.pingpong;

import javafx.scene.shape.Rectangle;

public class RectangleMove implements Runnable {
    private final Rectangle rect;
    final int frame = 290;
    final int moveX = 1;
    final int moveY = 1;

    public RectangleMove(Rectangle rect) {
        this.rect = rect;
    }

    @Override
    public void run() {
        //while (!Thread.currentThread().isInterrupted()) { // этот вариант, я так понимаю, предполагался, как правильное решение. Тем не менее, если поток запущен в вечный цикл, всё равно код работает корректно (просто прерывается, и зачем ему тогда зависеть от флага?).
        while (true) {
            int x = moveX; // сделал поля final. Поэтому пришлось вводить дополнительные локальные переменные. Какой в этом смысл?
            int y = moveY;
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
                return;
            }
        }
    }
}
