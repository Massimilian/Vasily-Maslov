package ru.job4j.homeworks;

//12.175. Определить:
//        а) координаты первого максимального элемента главной диагонали квадратного массива;
//        б) координаты первого минимального элемента побочной диагонали квадратного массива.
//        В обеих задачах принять, что диагональ просматривается сверху вниз.

public class Task12175 {
    public int returnMax(int[][] array) {
        int value = Integer.MIN_VALUE;
        int result = 0;
        for (int i = 0; i < array.length; i++) {
            if (value < array[i][i]) {
                value = array[i][i];
                result = i;
            }
        }
        return result;
    }

    public  int returnMin(int[][] array) {
        int value = Integer.MAX_VALUE;
        int result = 0;
        for (int i = 0; i < array.length; i++) {
            if (value > array[i][array.length - 1 - i]) {
                value = array[i][array.length - 1 - i];
                result = i;
            }
        }
        return result;
    }
}
