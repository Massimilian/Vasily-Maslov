package ru.job4j.homeworks;

//12.182. Дан квадратный массив размером 10 10, заполненный двузначными целыми числами.
//        Вывести на экран часть массива:
//        а) расположенную выше главной диагонали;
//        б) расположенную ниже побочной диагонали.

public class Task12182 {
    public int[][] printHalf(int[][] array, boolean upstairs) {
        int[][] result;
        if (upstairs) {
            result = new int[array.length / 2][array.length];
            for (int i = 0; i < array.length / 2; i++) {
                for (int j = 0; j < array[i].length; j++) {
                    System.out.printf("%d ", array[i][j]);
                    result[i][j] = array[i][j];
                }
                System.out.println();
            }
        } else {
            result = new int[array.length - array.length / 2][array.length];
            for (int i = array.length % 2 == 0 ? array.length - array.length / 2 : array.length - array.length / 2 - 1; i < array.length; i++) {
                for (int j = 0; j < array[i].length; j++) {
                    System.out.printf("%d ", array[i][j]);
                    result[i - array.length / 2][j] = array[i][j];
                }
                System.out.println();
            }
        }
        return result;
    }
}
