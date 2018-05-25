package ru.job4j.homeworks.tasks;

//11.4. Массив предназначен для хранения значений ростов двенадцати человек.
//        С помощью датчика случайных чисел заполнить массив целыми значениями,
//        лежащими в диапазоне от 163 до 190 включительно.

import java.util.Random;

public class Task114 {
    Random random = new Random();
    int min = 163;
    int max = 190;
    public int[] method(int number) {
        int[] result = new int[number];
        for (int i = 0; i < number; i++) {
            result[i] = random.nextInt(max - min) + min;
        }
        return result;
    }
}
