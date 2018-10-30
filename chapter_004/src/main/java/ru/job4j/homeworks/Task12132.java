package ru.job4j.homeworks;

import java.util.HashSet;
import java.util.Set;

//12.132. Определить, имеются ли в двумерном массиве одинаковые элементы.

public class Task12132 {
    public boolean hasEquals(int[][] array) {
        int length = 0;
        Set<Integer> set = new HashSet<Integer>();
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                length++;
                set.add(array[i][j]);
            }
        }
        return set.size() != length;
    }
}
