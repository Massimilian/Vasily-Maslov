package ru.job4j.homeworks;

// Дан двумерный массив.
// а) Переставить последнюю строку на место первой. При этом первую, вторую, третью, ... поднять.
// б) Переставить последний столбец на место первого. При этом первый, второй, третий, ... столбцы сместить вправо.
// в) Переставить k-ную строку на место s-ной (k > s). При этом (s + 1)-ю, (s + 2)-ю, ... s-ю строки поднять.
// г) Переставить k-ный столбец на место s-ного (k > s). При этом (s + 1)-й, (s + 2)-й, ... s-й столбцы сместить вghfво.


public class Task12252 {
    public int[][] circleRemoveArray(int[][] array) {
        return this.removeArrays(array, array.length - 1, 0);
    }

    public int[][] removeArrays(int[][] array, int from, int to) {
        int[][] result = new int[array.length][];
        result[to] = new int[array[from].length];
        for (int i = 0; i < array[from].length; i++) {
            result[to][i] = array[from][i];
        }
        for (int i = to; i < from; i++) {
            result[i + 1] = new int[array[i].length];
            for (int j = 0; j < array[i].length; j++) {
                result[i + 1][j] = array[i][j];
            }
        }
        for (int i = 0; i < array.length; i++) {
            if (i <= from && i >= to) {
                continue;
            }
            result[i] = new int[array[i].length];
            for (int j = 0; j < array[i].length; j++) {
                result[i][j] = array[i][j];
            }
        }
        return result;
    }

    // для работы предполагается массив с фиксированной длиной строк
    public int[][] circleRemoveColumn(int[][] array) {
        return this.removeColumn(array, array[0].length - 1, 0);
    }

    // для работы предполагается массив с фиксированной длиной строк
    public int[][] removeColumn(int[][] array, int from, int to) {
        int[][] result = new int[array.length][array[0].length];
        for (int i = 0; i < array.length; i++) {
            result[i][to] = array[i][from];
            for (int k = to; k < from; k++) {
                result[i][k + 1] = array[i][k];
            }
            for (int j = 0; j < array[i].length; j++) {
                if (j <= from && j >= to) {
                    continue;
                }
                result[i][j] = array[i][j];
            }
        }
        return result;
    }
}
