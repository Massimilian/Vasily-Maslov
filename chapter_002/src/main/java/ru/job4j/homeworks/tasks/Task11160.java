package ru.job4j.homeworks.tasks;

//11.160. Вставить заданное число в массив целых чисел:
//        а) после первого отрицательного элемента;
//        б) перед последним четным элементом.

public class Task11160 {
    public int[] enterNumberBeforeLastEven(int[] array, int number) {
        int[] result = new int[array.length + 1];
        boolean hasAdded = false;
        for (int i = array.length - 1; i >= 0; i--) {
            if (!hasAdded) {
                if (array[i] % 2 == 0) {
                    result[i + 1] = array[i];
                    result[i] = number;
                    hasAdded = true;
                } else {
                    result[i + 1] = array[i];
                }
            } else {
                result[i] = array[i];
            }
        }
        return result;
    }

    public int[] enterNumberAfterFirstMinus(int[] array, int number) {
        int[] result = new int[array.length + 1];
        boolean hasAdded = false;
        for (int i = 0; i < array.length; i++) {
            if (!hasAdded) {
                if (array[i] < 0) {
                    result[i] = array[i];
                    result[i + 1] = number;
                    hasAdded = true;
                } else {
                    result[i + 1] = number;
                }
            } else {
                result[i + 1] = array[i];
            }
        }
        return result;
    }
}
