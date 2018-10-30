package ru.job4j.homeworks;

//12.189.*Дан квадратный массив целых чисел. Определить, является ли он
//        симметричным относительно своей побочной диагонали.

public class Task12189 {
    public boolean isSimm(int[][] array) {
        boolean result = true;
        int count = array.length % 2 == 0 ? array.length / 2 : array.length / 2 + 1;
        for (int i = 0; i < count; i++) {
            for (int j = 0; j < array[i].length; j++) {
                result = array[i][j] == array[array.length - 1 - i][array.length - 1 - j];
                if (!result) {
                    break;
                }
            }
            if (!result) {
                break;
            }
        }
        return result;
    }
}
