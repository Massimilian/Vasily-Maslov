package ru.job4j.homeworks;

//12.48. Дан двумерный массив. Определить:
//        а) сумму квадратов элементов четвертого столбца массива;
//        б) сумму квадратов элементов k-й строки массива.

public class Task1248 {
    public int theSum(int[][] array, int point) {
        int result = 0;
        for (int i : array[point - 1]) {
            result += Math.pow(i, 2);
        }
        return result;
    }
}
