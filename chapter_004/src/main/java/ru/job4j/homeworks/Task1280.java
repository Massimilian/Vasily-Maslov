package ru.job4j.homeworks;

//12.80.*Дан двумерный массив. Определить количество различных элементов в нем.

import java.util.HashSet;

public class Task1280 {
    public int howMuchDifferents(int[][] array) {
        HashSet<Integer> hash = new HashSet<>();
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                hash.add(array[i][j]);
            }
        }
        return hash.size();
    }

    public int howMuchDifferentsWithoutCollections(int[][] array) {
        int size = 0;
        for (int i = 0; i < array.length; i++) {
            size += array[i].length;
        }
        boolean hasNull = false;
        boolean isCrossed = false;
        int position = 0;
        int[] temp = new int[size];
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                if (array[i][j] == 0 && !hasNull) {
                    hasNull = true;
                }
                for (int k = 0; k <= position; k++) {
                    if (array[i][j] == temp[k]) {
                        isCrossed = true;
                    }
                }
                if (!isCrossed) {
                    temp[position++] = array[i][j];
                }
                isCrossed = false;
            }
        }

        return hasNull ? position + 1 : position;
    }
}
