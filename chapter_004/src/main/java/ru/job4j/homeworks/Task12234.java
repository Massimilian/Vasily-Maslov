package ru.job4j.homeworks;

//12.234. Дан двумерный массив.
//        а) Удалить из него k-ю строку.
//        б) Удалить из него s-й столбец.

public class Task12234 {
    public int[][] deleteString(int[][] array, int pos) {
        int[][] result = new int[array.length - 1][];
        for (int i = 0; i < array.length - 1; i++) {
            if (i >= pos) {
                result[i] = new int[array[i + 1].length];
                for (int j = 0; j < array[i + 1].length; j++) {
                    result[i][j] = array[i + 1][j];
                }
            } else {
                result[i] = new int[array[i].length];
                for (int j = 0; j < array[i].length; j++) {
                    result[i][j] = array[i][j];
                }
            }
        }
        return result;
    }

    public int[][] deleteColumn(int[][] array, int pos) {
        int[][] result = new int[array.length][];
        for (int i = 0; i < array.length; i++) {
            result[i] = new int[array[i].length - 1];
            for (int j = 0; j < array[i].length - 1; j++) {
                if (j >= pos) {
                    result[i][j] = array[i][j + 1];
                } else {
                    result[i][j] = array[i][j];
                }
            }
        }
        return result;
    }
}
