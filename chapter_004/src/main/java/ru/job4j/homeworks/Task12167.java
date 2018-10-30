package ru.job4j.homeworks;

// 12.167. Составить программу, которая меняет местами два любых
// элемента побочной диагонали квадратного массива.

public class Task12167 {
    public void changePlaces(int[][] array, int first, int second) {
        array[first][array.length - 1 - first] += array[second][array.length - 1 - second];
        array[second][array.length - 1 - second] = array[first][array.length - 1 - first] - array[second][array.length - 1 - second];
        array[first][array.length - 1 - first] =  array[first][array.length - 1 - first] - array[second][array.length - 1 - second];
    }
}
