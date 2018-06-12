package ru.job4j.homeworks.tasks;

//11.151. Удалить из массива, в котором все элементы различны(последнее не учитываем для большей универмальности кода):
//        а) максимальный элемент;
//        б) минимальный элемент.

public class Task11151 {
    public int[] deleteMax(int[] array) {
        int count = 0;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < array.length; i++) {
            if (array[i] > max) {
                max = array[i];
                count = 1;
            } else if (array[i] == max) {
                count++;
            }
        }
        return getResult(array, count, max);
    }

    public int[] deleteMin(int[] array) {
        int count = 0;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < array.length; i++) {
            if (array[i] < min) {
                min = array[i];
                count = 1;
            } else if (array[i] == min) {
                count++;
            }
        }
        return getResult(array, count, min);
    }

    private int[] getResult(int[] array, int count, int point) {
        int[] result = new int[array.length - count];
        count = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == point) {
                continue;
            } else {
                result[count++] = array[i];
            }
        }
        return result;
    }
}
