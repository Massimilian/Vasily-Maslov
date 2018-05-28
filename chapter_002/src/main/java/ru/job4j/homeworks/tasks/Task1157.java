package ru.job4j.homeworks.tasks;

//11.57. Известны данные о количестве осадков, выпавших за каждый день февраля.
// Найти общее число осадков, выпавших по четным числам месяца.

public class Task1157 {
    public int sumOfRains(int[] array) {
        int result = 0;
        for (int i = 1; i < array.length; i += 2) {
            result += array[i];
        }
        return result;
    }
}
