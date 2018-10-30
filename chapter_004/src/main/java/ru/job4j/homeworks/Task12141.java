package ru.job4j.homeworks;

//12.141. Дан двумерный массив. Составить программу:
//        а) которая определяет, является ли последовательность элементов
//        некоторой строки массива упорядоченной по неубыванию;
//        б) которая определяет, является ли последовательность элементов
//        некоторого столбца массива упорядоченной по невозрастанию.
//        В случае отрицательного ответа в обеих задачах должны быть
//        напечатаны координаты первого элемента, нарушающего указанную упорядоченность.

public class Task12141 {
    public int sortedLine(int[][] array, int line) {
        int result = -1;
        for (int i = 1; i < array[line].length; i++) {
            if (array[line][i] < array[line][i - 1]) {
                result = i;
                break;
            }
        }
        return result;
    }

    public int sortedColumn(int[][] array, int column) {
        int result = -1;
        for (int i = 1; i < array.length; i++) {
            if (array[i][column] > array[i - 1][column]) {
                result = i;
                break;
            }
        }
        return result;
    }
}
