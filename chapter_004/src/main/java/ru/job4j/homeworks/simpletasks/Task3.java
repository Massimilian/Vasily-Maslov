package ru.job4j.homeworks.simpletasks;

//        Реализовать класс треугольник. Треугольник должен описываться через точки в системе координат.
//        Объект треугольник должен иметь методы: boolean exists() - проверяет существует ли треугольник или нет.
//        double area() - вычисляет площадь треугольника.
//        Если треугольник не существует выбросить исключение java.lang.IllegalStateException

public class Task3 {
    Task2 pointX;
    Task2 pointY;
    Task2 pointZ;

    public Task3(Task2 pointX, Task2 pointY, Task2 pointZ) {
        this.pointX = pointX;
        this.pointY = pointY;
        this.pointZ = pointZ;
        // считаю целесообразным здесь проверить треугольник на возможность существования.
        this.exist();
    }

    public boolean exist() {
        if (this.pointX.getX() == this.pointY.getX() && this.pointY.getX() == this.pointZ.getX()
                || this.pointX.getY() == this.pointY.getY() && this.pointX.getY() == this.pointZ.getY()
                || this.pointX.equals(this.pointY) || this.pointY.equals(this.pointZ) || this.pointZ.equals(this.pointX)) {
            throw new IllegalStateException();
        }
        return true;
    }

    public double area() {
        double p = (pointX.pointDistanceTo(pointY) + pointY.pointDistanceTo(pointZ) + pointZ.pointDistanceTo(pointX)) / 2;
        return Math.sqrt(p) * (p - pointX.pointDistanceTo(pointY)) * (p - pointY.pointDistanceTo(pointZ)) * (p - pointZ.pointDistanceTo(pointX));
    }
}
