package ru.job4j.homeworks;

//12.200. Заменить все элементы k-й строки и s-го столбца
//        двумерного массива противоположными по знаку
//        (элемент, стоящий на пересечении, не изменять).

public class Task12200 {
    public int[][] makeSubzero(int[][] array, int column, int str) {
        for (int i = 0; i < array.length; i++) {
            try {
                array[i][column] *= -1;
            } catch (ArrayIndexOutOfBoundsException aioobe) {
                continue;
            }
        }
        for (int i = 0; i < array[str].length; i++) {
            array[str][i] *= -1;
        }
        return array;
    }
}
