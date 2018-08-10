package ru.job4j.homeworks;

//12.31.*Используя датчик случайных чисел, заполнить двумерный массив неповторяющимися числами.

import java.util.HashSet;
import java.util.Iterator;
import java.util.Random;

public class Task1231 {
    public int[][] differentNumbersArray(int x, int y) {
        int[][] result = new int[x][y];
        Random random = new Random();
        HashSet<Integer> set = new HashSet<>();
        while (set.size() < x * y) {
            set.add(random.nextInt());
        }
        Iterator<Integer> iterator = set.iterator();
        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[i].length; j++) {
                result[i][j] = iterator.next();
            }
        }
        return result;
    }
}
