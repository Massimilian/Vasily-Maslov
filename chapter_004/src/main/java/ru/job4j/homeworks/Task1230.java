package ru.job4j.homeworks;

//12.30.*Дан двумерный массив размером N N. Построить последовательность
//        чисел, получающуюся при чтении этого массива по спирали.

import java.util.Arrays;

public class Task1230 {
    public int[][] snakeNumbers(int size) {
        int[][] result = new int[size][size];
        for (int i = 0; i < size; i++) {
            Arrays.fill(result[i], 0);
        }
        int minX = 0;
        int minY = 0;
        int x = 0;
        int y = 0;
        int maxX = size - 1;
        int maxY = size - 1;
        int count = 1;
        result[x][y] = count++;
        while (count <= Math.pow(size, 2)) {
            while (x < maxX) {
                x++;
                result[x][y] = count++;
            }
            minY++;
            while (y < maxY) {
                y++;
                result[x][y] = count++;
            }
            maxX--;
            while (x > minX) {
                x--;
                result[x][y] = count++;
            }
            maxY--;
            while (y > minY) {
                y--;
                result[x][y] = count++;
            }
            minX++;
        }
        return result;
    }
}