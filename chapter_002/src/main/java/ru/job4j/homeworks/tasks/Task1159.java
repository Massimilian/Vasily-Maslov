package ru.job4j.homeworks.tasks;

//11.59. Определить частное от деления суммы положительных элементов массива на модуль суммы отрицательных элементов.

public class Task1159 {
    public double quotient(int[] array) {
        int[] res = this.sumOfPlusAndOfMinus(array);
        if (res[1] == 0) {
            System.out.println("Error!");
            res[1] = 1;
        }
        return (double) res[0] / (double) Math.abs(res[1]);
    }

    private int[] sumOfPlusAndOfMinus(int[] array) {
        int[] result = {0, 0};
        for (int i : array) {
            if (i > 0) {
                result[0] += i;
            } else {
                result[1] += i;
            }
        }
        return result;
    }
}
