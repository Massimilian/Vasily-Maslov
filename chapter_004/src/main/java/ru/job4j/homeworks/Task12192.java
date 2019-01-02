package ru.job4j.homeworks;

//12.192. Дан двумерный массив. Поменять местами элементы:
//        а) расположенные в левом верхнем и левом нижнем углах массива;
//        б) расположенные в правом нижнем и правом верхнем углах массива.

public class Task12192 {
    public int[][] changes(int[][] array, int pos) {
        if (pos == 1) {
            array[0][0] += array[array.length - 1][array[array.length - 1].length - 1];
            array[array.length - 1][array[array.length - 1].length - 1] = array[0][0] - array[array.length - 1][array[array.length - 1].length - 1];
            array[0][0] -= array[array.length - 1][array[array.length - 1].length - 1];
        } else {
            array[array.length - 1][0] += array[0][array[0].length - 1];
            array[0][array[0].length - 1] = array[array.length - 1][0] - array[0][array[0].length - 1];
            array[array.length - 1][0] -= array[0][array[0].length - 1];
        }
        return array;
    }
}
