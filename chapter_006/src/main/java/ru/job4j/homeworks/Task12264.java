package ru.job4j.homeworks;

//12.264. Дан двумерный массив размером n n, заполненный целыми числами.
//        а) Все его элементы, кратные трем, записать в одномерный массив.
//        б) Все его положительные элементы записать в один одномерный массив, а остальные - в другой.

public class Task12264 {
    public int[] returnThrees(int[][] array) {
        int size = 0;
        int[] result = new int[size];
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                if (array[i][j] % 3 == 0 && array[i][j] != 0) {
                    int[] newResult = new int[++size];
                    for (int k = 0; k < result.length; k++) {
                        newResult[k] = result[k];
                    }
                    newResult[size - 1] = array[i][j];
                    result = newResult;
                }
            }
        }
        return result;
    }

    public int[][] returnPosAndNeg(int[][] array) {
        int sizePos = 0;
        int sizeNeg = 0;
        int[] pos = new int[sizePos];
        int[] neg = new int[sizeNeg];
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                if (array[i][j] > 0) {
                    pos = changeArray(pos, ++sizePos, array[i][j]);
                }
                if (array[i][j] < 0) {
                    neg = changeArray(neg, ++sizeNeg, array[i][j]);
                }
            }
        }
        int[][] result = {pos, neg};
        return result;
    }

    private int[] changeArray(int[] array, int size, int count) {
        int[] result = new int[size];
        for (int i = 0; i < array.length; i++) {
            result[i] = array[i];
        }
        result[size - 1] = count;
        return result;
    }
}
