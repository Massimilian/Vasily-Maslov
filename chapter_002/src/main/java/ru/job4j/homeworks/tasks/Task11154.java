package ru.job4j.homeworks.tasks;

//11.154. Удалить из массива, в котором все элементы различны, максимальный и минимальный элементы.

public class Task11154 {
    public int[] deleteMaxMin(int[] array) {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < array.length; i++) {
            if (max < array[i]) {
                max = array[i];
            }
            if (min > array[i]) {
                min = array[i];
            }
        }
        int[] result = new int[array.length - 2];
        int count = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == max || array[i] == min) {
                count++;
                continue;
            }
            result[i - count] = array[i];
        }
        return result;
    }
}
