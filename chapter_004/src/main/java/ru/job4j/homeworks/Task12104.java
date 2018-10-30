package ru.job4j.homeworks;

//12.104. Дан двумерный массив из двадцати двух строк и двух столбцов.
//        Найти максимальную сумму элементов в двух соседних строках.

public class Task12104 {
    public int findSum(int[][] array) {
        int result = Integer.MIN_VALUE;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length - 1; j++) {
                result = result < array[i][j] + array[i][j + 1] ? array[i][j] + array[i][j + 1] : result;
            }
        }
        return result;
    }
}
