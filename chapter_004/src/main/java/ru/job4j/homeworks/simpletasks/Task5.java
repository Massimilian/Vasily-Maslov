package ru.job4j.homeworks.simpletasks;

//        Реализовать класс прямоугольный* треугольник наследуя класс треугольник из задания 3.
//        Дополнить поведение метода boolean exists() - true, если треугольник равносторонний.
//        Остальное поведение оставить прежним.

//        *прямоугольный (по математическому определению) треугольник не может быть равносторонним. Может, имеется ввиду равносторонний?

public class Task5 extends Task3 {
    public Task5(Task2 pointX, Task2 pointY, Task2 pointZ) {
        super(pointX, pointY, pointZ);
    }

    @Override
    public boolean exist() {
        return pointX.pointDistanceTo(pointY) == pointY.pointDistanceTo(pointZ) && pointY.pointDistanceTo(pointZ) == pointZ.pointDistanceTo(pointX);
    }
}
