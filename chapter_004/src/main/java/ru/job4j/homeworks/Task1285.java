package ru.job4j.homeworks;

//12.85. Дан двумерный массив. Определить:
//        а) номер столбца, в котором расположен минимальный элемент четвертой строки массива.
//            Если элементов с минимальным значением в этой строке несколько,
//            то должен быть найден номер столбца самого левого из них;
//        б) номер строки, в котором расположен максимальный элемент третьего столбца массива.
//            Если элементов с максимальным значением в этом столбце несколько,
//            то должен быть найден номер строки самого нижнего из них.

public class Task1285 {
    public int findMin(int[][] array, int string) {
        int count = Integer.MAX_VALUE;
        int result = 0;
        for (int i = 0; i < array[string].length; i++) {
            if (array[string][i] < count) {
                count = array[string][i];
                result = i;
            }
        }
        return result;
    }

    public int findMax(int[][] array, int post) {
        int count = Integer.MIN_VALUE;
        int result = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i][post] > count) {
                count = array[i][post];
                result = i;
            }
        }
        return result;
    }
}
