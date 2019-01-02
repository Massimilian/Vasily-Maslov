package ru.job4j.homeworks;

//12.243. Дан двумерный массив. Вставить в него:
//        а) строку из нулей после первой из строк, количество нулей в которой рав-но заданному числу;
//        б) столбец из чисел 10 после первого из столбцов, у которых сумма элемен-тов не превышает заданное число.

public class Task12243 {
    public int[][] enterNumberString(int[][] array, int number, int count) {
        boolean isEntered = false;
        int[][] result = new int[array.length + 1][];
        int correct = 0;
        for (int i = 0; i < array.length; i++) {
            result[i + correct] = new int[array[i].length];
            for (int j = 0; j < array[i].length; j++) {
                result[i + correct][j] = array[i][j];
            }
            if (!isEntered && array[i].length == count) {
                isEntered = true;
                correct = 1;
                result[i + correct] = new int[array[i].length];
                for (int j = 0; j < array[i].length; j++) {
                    result[i + correct][j] = number;
                }
            }
        }
        return result;
    }

    // при условии работы с массивом с одинаковыми по размеру строками
    public int[][] enterNumbersColumn(int[][] array, int number, int count) {
        int[][] result = new int[array.length][array[0].length + 1];
        boolean isEntered = false;
        int correct = 0;
        int sum;
        for (int i = 0; i < array[0].length; i++) {
            sum = 0;
            for (int j = 0; j < array.length; j++) {
                result[j][i + correct] = array[j][i];
                sum += array[j][i];
            }
            if (!isEntered && sum > count) {
                isEntered = true;
                correct = 1;
                for (int j = 0; j < array.length; j++) {
                    result[j][i + correct] = number;
                }
            }
        }
        return result;
    }
}
