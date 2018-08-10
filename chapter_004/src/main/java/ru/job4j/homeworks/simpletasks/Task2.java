package ru.job4j.homeworks.simpletasks;

//        Реализовать класс точку, описывающую точку в системе координат x, y - Point(x, y).
//        Объект точка должен иметь методы double Point#distanceTo(Point point) -
//        метод должен вычислять расстояние между двумя точками.

import java.util.Objects;

public class Task2 {
    private double x;
    private double y;

    public Task2(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Task2 task2 = (Task2) o;
        return x == task2.x && y == task2.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }

    public double pointDistanceTo(Task2 point) {
        return Math.sqrt(Math.pow(this.x - point.getX(), 2) + Math.pow(this.y - point.getY(), 2));
    }
}
