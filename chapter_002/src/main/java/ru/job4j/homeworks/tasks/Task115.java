package ru.job4j.homeworks.tasks;


//        11.5. Массив предназначен для хранения значений весов двадцати человек.
//        С помощью датчика случайных чисел заполнить массив целыми значениями,
//        лежащими в диапазоне от 50 до 100 включительно.

import java.util.Random;

public class Task115 {
    public int[] peopleWeight() {
        Random random = new Random();
        int[] peopleWeight = new int[20];
        for (int i = 0; i < peopleWeight.length; i++) {
            peopleWeight[i] = random.nextInt(50) + 50;
            }
            return peopleWeight;
    }
}
