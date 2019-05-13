package ru.job4j.homeworks;

//12.253. Дан двумерный массив.
//        а) Переставить последнюю строку на место первой.
//        При этом первую, вторую, ..., предпоследнюю строки опустить.
//        б) Переставить последний столбец на место первого.
//        При этом первый, второй, ..., предпоследний столбцы сместить вправо.
//        в) Переставить s-ю строку на место k-й (s > k).
//        При этом k-ю, (k + 1)-ю, ..., (s – 1)-ю строки опустить.
//        г) Переставить a-й столбец на место b-го (a > b).
//        При этом b-й, (b + 1)-й, ..., (a – 1)-й столбцы сместить вправо.

public class Task12253 {
    public int[][] changeString(int[][] array) {
        int[][] result = new int[array.length][];
        for (int i = 0; i < array.length - 1; i++) {
            result[i + 1] = new int[array[i].length];
            System.arraycopy(array[i], 0, result[i + 1], 0, array[i].length);
        }
        result[0] = new int[array[array.length - 1].length];
        System.arraycopy(array[array.length - 1], 0, result[0], 0, array[array.length - 1].length);
        return result;
    }


    /**
     * Only for matrixes!
     *
     * @param array
     * @return changed array
     */
    public int[][] changeColumn(int[][] array) {
        int[][] result = new int[array.length][array.length];
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length; j++) {
                if (j == 0) {
                    result[i][j] = array[i][array.length - 1];
                } else {
                    result[i][j] = array[i][j - 1];
                }
            }
        }
        return result;
    }

    public int[][] specialChangeString(int[][] array, int x, int y) {
        int[][] result = new int[array.length][];
        for (int i = 0; i < array.length; i++) {
            if (i < x - 1 || i > y - 1) {
                result[i] = new int[array[i].length];
                System.arraycopy(array[i], 0, result[i], 0, array[i].length);
            } else if (i < array.length - 1) {
                result[i + 1] = new int[array[i].length];
                System.arraycopy(array[i], 0, result[i + 1], 0, array[i].length);
            }
        }
        result[x - 1] = new int[array[y - 1].length];
        System.arraycopy(array[y - 1], 0, result[x - 1], 0, array[y - 1].length);
        return result;
    }

    /**
     * Only for matrixes!
     *
     * @param array
     * @param x
     * @param y
     * @return changed array
     */

    public int[][] specialChangeColumn(int[][] array, int x, int y) {
        int[][] result = new int[array.length][array.length];
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length; j++) {
                if (j == x - 1) {
                    result[i][j] = array[i][y - 1];
                } else if (j > x - 1 && j < y) {
                    result[i][j] = array[i][j - 1];
                } else {
                    result[i][j] = array[i][j];
                }
            }
        }
        return result;
    }
}
