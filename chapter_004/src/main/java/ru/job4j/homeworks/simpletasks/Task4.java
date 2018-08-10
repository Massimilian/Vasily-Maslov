package ru.job4j.homeworks.simpletasks;

//        Реализовать класс равнобедренный треугольник наследуя класс треугольник из задания 3.
//        Дополнить поведение метода boolean exists() - true, если треугольник равнобедренный.
//        Остальное поведение оставить прежним.

public class Task4 extends Task3 {
    public Task4(Task2 pointX, Task2 pointY, Task2 pointZ) {
        super(pointX, pointY, pointZ);
    }

    @Override
    public boolean exist() {
        super.exist();
        return pointX.pointDistanceTo(pointY) == pointY.pointDistanceTo(pointZ)
                || pointY.pointDistanceTo(pointZ) == pointZ.pointDistanceTo(pointX)
                || pointZ.pointDistanceTo(pointX) == pointX.pointDistanceTo(pointY);
    }
}
