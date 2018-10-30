package ru.job4j.homeworks;

//12.188.*Дан квадратный массив целых чисел. Определить, является ли он
//        симметричным относительно своей главной диагонали.

public class Task12188 {
    public boolean isSimm(int[][] array) {
        boolean result = true;
        for (int i = 0; i <= array.length / 2; i++) {
            for (int j = 0; j < array.length; j++) {
                if (array[i][j] != array[array.length - 1 - i][array.length - 1 - j]) {
                    result = false;
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
