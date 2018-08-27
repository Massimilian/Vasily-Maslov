package ru.job4j.homeworks;

//12.83. Составить программу:
//        а) нахождения минимального значения среди элементов любой строки двумерного массива;
//        б) нахождения максимального значения среди элементов любого столбца двумерного массива.

import java.util.Arrays;

public class Task1283 {
    public int[] findMin(int[][] array) {
        int[] result = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            int temp = Integer.MAX_VALUE;
            for (int j = 0; j < array[i].length; j++) {
                if (array[i][j] < temp) {
                    temp = array[i][j];
                }
            }
            result[i] = temp;
        }
        return result;
    }

    public int[] findMax(int[][] array) {
        int[] result = new int[array[0].length];
        for (int i = 0; i < array[0].length; i++) {
            int temp = Integer.MIN_VALUE;
            for (int j = 0; j < array.length; j++) {
                if (array[j][i] > temp) {
                    temp = array[j][i];
                }
            }
            result[i] = temp;
        }
        return result;
    }
}
