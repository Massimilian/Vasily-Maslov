package ru.job4j.homeworks;

//12.216. Дан двумерный массив. Составить программу:
//        а) которая меняет местами две любые строки;
//        б) которая меняет местами два любых столбца.

public class Task12216 {
    public int[][] changeString(int[][] array, int from, int to) {
        int[][] newArray = new int[array.length][];
        int pos;
        boolean changed;
        for (int i = 0; i < array.length; i++) {
            pos = i;
            changed = false;
            if (i == from) {
                pos = to;
                changed = true;
            }
            pos = i == to && !changed ? from : pos;
            newArray[pos] = new int[array[i].length];
            for (int j = 0; j < array[i].length; j++) {
                newArray[pos][j] = array[i][j];
            }
        }
        return newArray;
    }

    public int[][] changeColumn(int[][] array, int from, int to) {
        int length = 0;
        for (int i = 0; i < array.length; i++) {
            length = length < array[i].length ? array[i].length : length;
        }
        int[][] newArray = new int[array.length][length];
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < length; j++) {
                try {
                    newArray[i][j] = array[i][j];
                } catch (ArrayIndexOutOfBoundsException aioobe) {
                    newArray[i][j] = 0;
                }
            }
        }
        for (int i = 0; i < newArray[to].length; i++) {
            newArray[i][to] += newArray[i][from];
            newArray[i][from] = newArray[i][to] - newArray[i][from];
            newArray[i][to] -= newArray[i][from];
        }
        return newArray;
    }
}
