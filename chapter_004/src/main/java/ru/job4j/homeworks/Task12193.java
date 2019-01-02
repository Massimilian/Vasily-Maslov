package ru.job4j.homeworks;

//12.193. Дан двумерный массив. Поменять местами первый максимальный
//        и последний минимальный элементы массива.
//        Принять, что массив просматривается построчно сверху вниз,
//        а в каждой строке - слева направо.

public class Task12193 {
    public int[][] changeMinAndMax(int[][] array) {
        int xMax = 0;
        int yMax = 0;
        int xMin = 0;
        int yMin = 0;
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                if (array[i][j] > max) {
                    max = array[i][j];
                    xMax = i;
                    yMax = j;
                }
                if (array[i][j] <= min) {
                    min = array[i][j];
                    xMin = i;
                    yMin = j;
                }
            }
        }
        array[xMax][yMax] += array[xMin][yMin];
        array[xMin][yMin] = array[xMax][yMax] - array[xMin][yMin];
        array[xMax][yMax] -= array[xMin][yMin];
        return array;
    }
}
