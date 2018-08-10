package ru.job4j.homeworks;

//12.62. Дан двумерный массив. Найти:
//        а) сумму элементов каждой строки;
//        б) сумму элементов каждого столбца.

public class Task1262 {
    public int[] stringSum(int[][] array) {
        int[] result = new int[array.length];
        int count = 0;
        for (int[] arr : array) {
            for (int i : arr) {
                result[count] += i;
            }
            count++;
        }
        return result;
    }

    public int[] postSum(int[][] array) {
        int size = 0;
        for (int i = 0; i < array.length; i++) {
            size = array[i].length > size ? array[i].length : size;
        }
        int[] result = new int[size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < array.length; j++) {
                try {
                    result[i] += array[j][i];
                } catch (ArrayIndexOutOfBoundsException aioobe) {
                    continue;
                }
            }
        }
        return result;
    }
}
