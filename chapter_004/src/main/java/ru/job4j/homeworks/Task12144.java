package ru.job4j.homeworks;

//12.144. Дан двумерный массив целых чисел. Выяснить:
//        а) имеется ли в нем положительный элемент;
//        б) имеется ли в нем элемент, последняя цифра которого равна а.

public class Task12144 {
    public boolean hasPositive(int[][] array) {
        boolean result = false;
        for (int i = 0; i < array.length; i++) {
            if (result) {
                break;
            }
            for (int j = 0; j < array[i].length; j++) {
                if (array[i][j] > 0) {
                    result = true;
                    break;
                }
            }
        }
        return result;
    }

    public boolean hasNumber(int[][] array, int number) {
        boolean result = false;
        for (int i = 0; i < array.length; i++) {
            if (result) {
                break;
            }
            for (int j = 0; j < array[i].length; j++) {
                if ((Math.abs(array[i][j]) - number) % 10 == 0 && array[i][j] != 0) {
                    result = true;
                    break;
                }
            }
        }
        return result;
    }
}
