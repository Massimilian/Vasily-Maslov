package ru.job4j.homeworks;

//12.206. Дан двумерный массив целых чисел.
//        а) Ко всем четным элементам массива прибавить первый элемент соответствующей строки.
//        б) Все элементы массива, оканчивающиеся на 2, умножить на последний элемент соответствующего столбца.
//        в) Ко всем положительным элементам массива прибавить последний элемент соответствующей строки,
//        а к остальным - первый элемент такой же строки.
//        г) Все элементы массива, сумма индексов которых кратна пяти, заменить нулями.

public class Task12206 {
    public int[][] changeEvens(int[][] array) {
        int temp;
        for (int i = 0; i < array.length; i++) {
            temp = array[i][0];
            for (int j = 0; j < array[i].length; j++) {
                array[i][j] = array[i][j] % 2 == 0 && array[i][j] != 0 ? array[i][j] + temp : array[i][j];
            }
        }
        return array;
    }

    public int[][] changeNumbersWithTwo(int[][] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                array[i][j] = (array[i][j] - 2) % 10 == 0 ? array[i][j] * array[i][array[i].length - 1] : array[i][j];
            }
        }
        return array;
    }

    public int[][] changePositives(int[][] array) {
        int temp;
        for (int i = 0; i < array.length; i++) {
            temp = array[i][0];
            for (int j = 0; j < array[i].length; j++) {
                array[i][j] = array[i][j] > 0 ? array[i][j] + array[i][array[i].length - 1] : array[i][j] + temp;
            }
        }
        return array;
    }

    public int[][] changeFifth(int[][] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                array[i][j] = (i + j) % 5 == 0 && i + j != 0 ? 0 : array[i][j];
            }
        }
        return array;
    }
}
