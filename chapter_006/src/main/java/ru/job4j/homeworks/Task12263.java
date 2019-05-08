package ru.job4j.homeworks;

//Дан двумерный массив размером n n. Сформировать:
//        а) одномерный массив из элементов заданного массива, расположенных над главной диагональю;
//        б) одномерный массив из элементов заданного массива, расположенных под главной диагональю;
//        в) одномерный массив из элементов заданного массива, расположенных над побочной диагональю;
//        г) одномерный массив из элементов заданного массива, расположенных под побочной диагональю.

public class Task12263 {
    public int[] upDiagonal(int[][] array) {
        int[] result = new int[checkNumber(array.length)];
        int up = array.length - 1;
        int count = 0;
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < up; j++) {
                result[count++] = array[i][j];
            }
            up--;
        }
        return result;
    }

    public int[] downDiagonal(int[][] array) {
        int[] result = new int[checkNumber(array.length)];
        int down = array.length - 1;
        int count = 0;
        for (int i = 1; i < array.length; i++) {
            for (int j = down; j < array.length; j++) {
                result[count++] = array[i][j];
            }
            down--;
        }
        return result;
    }

    public int[] upSecondDiagonal(int[][] array) {
        int[] result = new int[checkNumber(array.length)];
        int up = 1;
        int count = 0;
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = up; j < array[i].length; j++) {
                result[count++] = array[i][j];
            }
            up++;
        }
        return result;
    }

    public int[] downSecondDiagonal(int[][] array) {
        int[] result = new int[checkNumber(array.length)];
        int down = 1;
        int count = 0;
        for (int i = 1; i < array.length; i++) {
            for (int j = 0; j < down; j++) {
                result[count++] = array[i][j];
            }
            down++;
        }
        return result;
    }

    private int checkNumber(int number) {
        int result = 0;
        while (number != 0) {
            result += --number;
        }
        return result;
    }
}
