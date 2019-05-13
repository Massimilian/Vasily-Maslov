package ru.job4j.homeworks;

// Дан двумерный массив из двадцати строк и трех столбцов.
// Перенести пер-вые k строк в конец массива, соблюдая порядок их следования.

public class Task12254 {
    public int[][] changeStrings(int[][] array, int count) {
        int[][] result = new int[array.length][];
        int place = 0;
        for (int i = array.length - count; i < result.length; i++) {
            result[i] = new int[array[place].length];
            System.arraycopy(array[place], 0, result[i], 0, array[place].length);
            place++;
        }
        for (int i = 0; i < array.length - count; i++) {
            result[i] = new int[array[place].length];
            for (int j = 0; j < array[place].length; j++) {
                result[i][j] = array[place][j];
            }
            place++;
        }
        return result;
    }
}
