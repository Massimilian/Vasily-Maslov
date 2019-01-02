package ru.job4j.homeworks;

//12.240. Дан двумерный массив. Удалить строку и столбец,
//        на пересечении которых расположен наименьший
//        по модулю элемент массива.

import java.util.ArrayList;

public class Task12240 {
    public int[][] modifyArray(int[][] array) {
        int line = 0;
        int column = 0;
        int count = Integer.MAX_VALUE;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                if (count > Math.abs(array[i][j])) {
                    count = Math.abs(array[i][j]);
                    column = i;
                    line = j;
                }
            }
        }
        int[][] result = new int[array.length - 1][];
        boolean hasLineWorked = false;
        boolean hasColumnWorked = false;
        for (int i = 0; i < array.length; i++) {
            hasLineWorked = false;
            if (i == column) {
                hasColumnWorked = true;
                continue;
            }
            if (!hasColumnWorked) {
                result[i] = array[i].length > line ? new int[array[i].length - 1] : new int[array[i].length];
            } else {
                result[i - 1] = array[i].length > line ? new int[array[i].length - 1] : new int[array[i].length];
            }
            for (int j = 0; j < array[i].length; j++) {
                if (j == line) {
                    hasLineWorked = true;
                    continue;
                }
                if (!hasColumnWorked && !hasLineWorked) {
                    result[i][j] = array[i][j];
                } else if (!hasColumnWorked && hasLineWorked) {
                    result[i][j - 1] = array[i][j];
                } else if (hasColumnWorked && !hasLineWorked) {
                    result[i - 1][j] = array[i][j];
                } else if (hasColumnWorked && hasLineWorked) {
                    result[i - 1][j - 1] = array[i][j];
                }
            }
        }
        return result;
    }
}

