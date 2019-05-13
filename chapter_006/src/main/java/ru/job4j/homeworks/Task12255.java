package ru.job4j.homeworks;

// Дан двумерный массив из пяти строк и двадцати столбцов.
// Перенести первые s столбцов в конец массива, соблюдая порядок их следования.

public class Task12255 {
    public int[][] changeColumns(int[][] array, int count) {
        int[][] result = new int[array.length][array[0].length];
        for (int i = 0; i < array.length; i++) {
            int point = 0;
            for (int j = 0; j < array[i].length; j++) {
                if (j < array[i].length - count) {
                    result[i][j] = array[i][j + count];
                } else {
                    result[i][j] = array[i][point++];
                }
            }
        }
        return result;
    }
}
