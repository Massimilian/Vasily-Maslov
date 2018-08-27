package ru.job4j.homeworks.simpletasks.task19;

import java.util.Objects;

public class Point19 {
    private int x;
    private int y;
    private int queue = 0;

    public Point19(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void incr() {
        queue++;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setQueue(int queue) {
        this.queue = queue;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Point19 point19 = (Point19) o;
        return x == point19.x && y == point19.y;
    }

    @Override
    public int hashCode() {

        return Objects.hash(x, y);
    }
}
