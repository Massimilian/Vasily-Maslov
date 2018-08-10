package ru.job4j.homeworks.simpletasks;

// Задан массив чисел со значениями 0 и 1.
// Нужно проверить, что все значения в массиве равны 1.
// Например, [0, 1] - false, [1, 1] - true,

public class Task11 {
    public boolean allOnes(int[] array) {
        // можно сделать ещё проще - просто сделать два return и не вводить переменную theOne (но тогда будет два return, что нежелательно)
        boolean theOne = true;
        for (int i = 0; i < array.length; i++) {
            if (array[i] != 1) {
                theOne = false;
                break;
            }
        }
        return theOne;
    }
}
