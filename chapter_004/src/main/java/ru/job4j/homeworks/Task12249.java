package ru.job4j.homeworks;

//12.249. Дан двумерный массив целых чисел. Вставить в него:
//        а) строку из нулей перед всеми строками, в которых количество положительных
//        элементов равно количеству отрицательных;
//        б) столбец из чисел 10 перед всеми столбцами, в которых количество положительных
//        элементов больше количества отрицательных.

import java.util.ArrayList;

public class Task12249 {
    public int[][] enterStrings(int[][] array, int number) {
        ArrayList<Integer> positions = new ArrayList<>();
        int count;
        for (int i = 0; i < array.length; i++) {
            count = 0;
            for (int j = 0; j < array[i].length; j++) {
                if (array[i][j] > 0) {
                    count++;
                }
                if (array[i][j] < 0) {
                    count--;
                }
            }
            if (count == 0) {
                positions.add(i);
            }
        }
        int[][] result = new int[array.length + positions.size()][];
        count = 0;
        for (int i = 0; i < array.length; i++) {
            if (positions.get(count) == i) {
                result[i + count] = new int[array[i].length];
                for (int j = 0; j < array[i].length; j++) {
                    result[i + count][j] = number;
                }
                count++;
            }
            result[i + count] = new int[array[i].length];
            for (int j = 0; j < array[i].length; j++) {
                result[i + count][j] = array[i][j];
            }
        }
        return result;
    }

    // только для массивов с фиксированной длиной строк
    public int[][] enterColumn(int[][] array, int number) {
        ArrayList<Integer> positions = new ArrayList<>();
        int count;
        for (int i = 0; i < array[0].length; i++) {
            count = 0;
            for (int j = 0; j < array.length; j++) {
                if (array[j][i] > 0) {
                    count++;
                }
                if (array[j][i] < 0) {
                    count--;
                }
            }
            if (count > 0) {
                positions.add(i);
            }
        }
        int[][] result = new int[array.length][array[0].length + positions.size()];
        count = 0;
        for (int i = 0; i < array[0].length; i++) {
            if (positions.get(count) == i) {
                for (int j = 0; j < array.length; j++) {
                    result[j][i + count] = number;
                }
                count++;
            }
            for (int j = 0; j < array.length; j++) {
                result[j][i + count] = array[j][i];
            }
        }
        return result;
    }
}
