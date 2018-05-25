package ru.job4j.homeworks.tasks;

//11.11.* Используя датчик случайных чисел, заполнить массив из двадцати элемен-тов неповторяющимися числами.

import java.util.Random;

public class Task1111 {
    Random random = new Random();
    public int[] makeArray(int size) {
        int[] result = new int[size];
        boolean isGood;
        do {
            fillArray(result);
            isGood = true;
            for (int i = 0; i < result.length - 1; i++) {
                for (int j = i + 1; j < result.length; j++) {
                    if (result[i] == result[j]) {
                        isGood = false;
                        break;
                    }
                }
            }
        } while (!isGood);
        return result;
    }

    private int[] fillArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt();
        }
        return array;
    }
}
