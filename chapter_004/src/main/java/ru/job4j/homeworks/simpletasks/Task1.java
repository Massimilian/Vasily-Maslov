package ru.job4j.homeworks.simpletasks;

//Реализовать программу калькулятор.
// Калькулятор должен выполнять операции: сложение, вычитание, умножение, деление, возведение в степень.
// При выполнении деления ввести проверку на 0.
// Если второй аргумент 0 нужно выкинуть исключение java.lang.IllegalStateException

public class Task1 {
    public double sum(double x, double y) {
        return x + y;
    }

    public double subtraction(double x, double y) {
        return x - y;
    }

    public double multiplication(double x, double y) {
        return x * y;
    }

    public double division(double x, double y) {
        if (y == 0) {
            throw new IllegalStateException("Impossible division (0)!");
        }
        return x / y;
    }

    public double pow(double x, double y) {
        return Math.pow(x, y);
    }
}
