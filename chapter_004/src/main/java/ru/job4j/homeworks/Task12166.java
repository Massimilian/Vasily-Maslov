package ru.job4j.homeworks;

//12.166. Составить программу, которая меняет местами
// два любых элемента главной диагонали квадратного массива.

public class Task12166 {
    public void changePlaces(int[][] array, int first, int second) {
        array[first][first] += array[second][second];
        array[second][second] = array[first][first] - array[second][second];
        array[first][first] =  array[first][first] - array[second][second];
    }
}
