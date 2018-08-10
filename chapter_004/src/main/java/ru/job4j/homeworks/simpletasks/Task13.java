package ru.job4j.homeworks.simpletasks;

// Задан числовой массив.
// Нужно проверить, что все значения в массиве одинаковые.
// Например, [0, 0, 0] - true, [1, 1, 1] - true, [0, 1, 1] - false,

public class Task13 {
    public boolean allEquals(int[] array) {
        int test = array[0];
        boolean eq = true;
        for (int i = 1; i < array.length; i++) {
            eq = test == array[i];
            if (!eq) {
                break;
            }
        }
        return eq;
    }
}
