package ru.job4j.homeworks;

//12.179. Заполнить квадратный массив размером n n таким образом, чтобы:
//        а) его элементы имели значения, симметричные относительно главной диагонали;
//        б) его элементы имели значения, симметричные относительно побочной диагонали.

public class Task12179 {
    public int[][] fillArray(int[][] array, int correct) {
        for (int i = 0; i < array.length; i++) {
            for (int j = i + 1; j < array[i].length; j++) {
                array[i][j] = array[i][j - 1] + correct;
                array[j][i] = array[i][j - 1] + correct;
            }
        }
        return array;
    }

    public int[][] fillArrayWithAnotherWay(int[][] array, int correct) {
        for (int i = 0; i < array.length; i++) {
            for (int j = array.length - 1 - i; j > 0; j--) {
                array[i][j - 1] = array[i][j] + correct;
                array[array.length - j][array.length - 1 - i] = array[i][j] + correct;
            }
        }
        return array;
    }
}
