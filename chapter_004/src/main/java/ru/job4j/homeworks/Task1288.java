package ru.job4j.homeworks;

//12.88. Составить программу:
//        а) нахождения номера столбца, в котором расположен максимальный элемент любой строки двумерного массива.
//        Если элементов с максимальным значением в этой строке несколько,
//        то должен быть найден номер столбца самого правого из них;
//        б) нахождения номера строки, в которой расположен минимальный элемент любого столбца двумерного массива.
//        Если элементов с минимальным значением в этом столбце несколько,
//        то должен быть найден номер строки самого нижнего из них.

public class Task1288 {
    public int findColumn(int[][] array) {
        int i = Integer.MIN_VALUE;
        int result = 0;
        for (int j = 0; j < array.length; j++) {
            for (int k = 0; k < array[j].length; k++) {
                if (array[j][k] > i) {
                    i = array[j][k];
                    result = k;
                }
            }
        }
        return result;
    }

    public int findString(int[][] array) {
        int value = Integer.MAX_VALUE;
        int result = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                if (array[i][j] <= value) {
                    value = array[i][j];
                    result = i;
                }
            }
        }
        return result;
    }
}
