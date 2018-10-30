package ru.job4j.homeworks;

//12.142. Дан двумерный массив целых чисел.
//        Принимая, что массив просматривает-ся построчно сверху вниз,
//        а в каждой строке — слева направо, найти:
//        а) координаты (номера) первого элемента, кратного семи;
//        б) координаты (номера) последнего элемента, большего числа z.
//        В обеих задачах принять, что такие элементы в массиве есть.

public class Task12142 {
    public int[] firstDivisible(int[][] array, int number) {
        int[] result = {-1, -1};
        for (int i = 0; i < array.length; i++) {
            if (result[0] != -1) {
                break;
            }
            for (int j = 0; j < array[i].length; j++) {
                if (array[i][j] % number == 0) {
                    result[0] = i;
                    result[1] = j;
                    break;
                }
            }
        }
        return result;
    }

    public int[] lastMax(int[][] array, int number) {
        int[] result = {-1, -1};
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                if (array[i][j] > number) {
                    result[0] = i;
                    result[1] = j;
                }
            }
        }
        return result;
    }
}
