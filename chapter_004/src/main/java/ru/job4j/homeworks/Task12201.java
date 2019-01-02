package ru.job4j.homeworks;

// 12.201. В каждой строке двумерного массива поменять местами первый элемент и любой из максимальных.

public class Task12201 {
    public int[][] changeElement(int[][] array) {
        int max;
        int pos = 0;
        for (int i = 0; i < array.length; i++) {
            max = Integer.MIN_VALUE;
            for (int j = 0; j < array[i].length; j++) {
                if (array[i][j] > max) {
                    max = array[i][j];
                    pos = j;
                }
            }
            array[i][0] += array[i][pos];
            array[i][pos] = array[i][0] - array[i][pos];
            array[i][0] -= array[i][pos];
        }
        return array;
    }
}
