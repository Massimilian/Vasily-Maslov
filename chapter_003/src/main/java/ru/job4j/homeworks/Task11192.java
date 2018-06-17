package ru.job4j.homeworks;

//11.192.*В массиве имеются только два одинаковых элемента. Найти их.

import java.util.TreeMap;

public class Task11192 {
    public TreeMap<Integer, int[]> findEquals(char[] array) {
        char check = this.checkCount(array);
        TreeMap<Integer, int[]> result = new TreeMap<>();
        int count = 0;
        for (int i = 0; i < array.length - 1; i++) {
            if (array[i] == check) {
                continue;
            }
            for (int j = i + 1; j < array.length; j++) {
                if (array[i] == array[j]) {
                    result.put(++count, new int[]{i + 1, j + 1});
                    array[i] = check;
                    array[j] = check;
                    break;
                }
            }
        }
        return result;
    }

    private char checkCount(char[] array) {
        char ch = 0;
        boolean crossed;
        do {
            crossed = false;
            for (int i = 0; i < array.length; i++) {
                if (ch == array[i]) {
                    crossed = true;
                    ch++;
                    break;
                }
            }
        } while (crossed);
        return ch;
    }
}
