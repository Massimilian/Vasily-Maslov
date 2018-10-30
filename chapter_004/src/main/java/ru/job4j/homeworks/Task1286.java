package ru.job4j.homeworks;

//12.86. Дан двумерный массив. Определить:
//        а) номер строки, в которой расположен максимальный элемент второго столбца массива.
//        Если элементов с максимальным значением в этом столбце несколько,
//        то должен быть найден номер строки самого верхнего из них;
//        б) номер столбца, в котором расположен минимальный элемент третьей строки массива.
//        Если элементов с минимальным значением в этой строке несколько,
//        то должен быть найден номер столбца самого правого из них.

public class Task1286 {
    public int findMax(int[][] array, int column) {
        int result = 0;
        int temp = Integer.MIN_VALUE;
        for (int i = 0; i < array.length; i++) {
            if (temp < array[i][column]) {
                temp = array[i][column];
                result = i;
            }
        }
        return result;
    }

    public int findMin(int[][] array, int column) {
        int result = 0;
        int temp = Integer.MAX_VALUE;
        for (int i = 0; i < array.length; i++) {
            if (temp > array[i][column]) {
                temp = array[i][column];
                result = i;
            }
        }
        return result;
    }
}
