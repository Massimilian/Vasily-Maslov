package ru.job4j.homeworks;

//12.269. Дан двумерный массив целых чисел.
//        а) Сформировать одномерный массив, каждый элемент которого равен пер-вому четному элементу
//        соответствующего столбца двумерного массива (если такого элемента в столбце нет, то он равен нулю).
//        б) Сформировать одномерный массив, каждый элемент которого равен по-следнему нечетному элементу
//        соответствующей строки двумерного масси-ва (если такого элемента в строке нет, то он равен нулю).

public class Task12269 {
    public int[] getEvens(int[][] array) {
        int[] result = new int[array.length];
        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                if (array[i][j] % 2 == 0 && array[i][j] != 0) {
                    result[i] = array[i][j];
                    break;
                }
            }
        }
        return result;
    }

    public int[] getNotEvens(int[][] array) {
        int[] result = new int[array.length];
        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                if (array[i][j] % 2 != 0) {
                    result[i] = array[i][j];
                }
            }
        }
        return result;
    }
}

