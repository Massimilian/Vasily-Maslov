package ru.job4j.homeworks;

//12.183. Дан квадратный массив размером 15 15, заполненный цифрами. Вывести
//        на экран часть массива:
//        а) расположенную выше побочной диагонали;
//        б) расположенную ниже главной диагонали.

public class Task12183 {
    public int[][] halfArray(int[][] array, boolean leftPart) {
        int[][] result;
        if (leftPart) {
            result = new int[array.length][array[0].length / 2];
            for (int i = 0; i < array.length; i++) {
                for (int j = 0; j < array[0].length / 2; j++) {
                    result[i][j] = array[i][j];
                    System.out.printf("%d ", result[i][j]);
                }
                System.out.println();
            }
        } else {
            result = new int[array.length][array.length - array[0].length / 2];
            for (int i = 0; i < result.length; i++) {
                for (int j = array[i].length / 2; j < array[i].length; j++) {
                    result[i][j - array[i].length / 2] = array[i][j];
                    System.out.printf("%d ", result[i][j - array[i].length / 2]);
                }
                System.out.println();
            }
        }
        return result;
    }
}
