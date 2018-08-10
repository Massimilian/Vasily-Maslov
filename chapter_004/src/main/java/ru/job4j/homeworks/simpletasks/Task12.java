package ru.job4j.homeworks.simpletasks;

// Задан массив чисел со значениями 0 и 1.
// Нужно проверить, что в массиве есть последовательности из трех и больше единиц.
// Например, [0, 1, 1] - false, [1, 1, 1] - true,

public class Task12 {
    public boolean threeOnes(int[] array) {
        boolean res = false;
        int count = 0;
        for (int i : array) {
            count = i == 1 ? count + 1 : 0;
            if (count == 3) {
                res = true;
                break;
            }
        }
        return res;
    }
}
