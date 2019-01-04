package ru.job4j.homeworks.tasks;

//11.163. Вставить в массив два заданных числа: первое после любого из максимальных элементов, второе — перед ним.

public class Task11163 {
    public int[] putNumber(int[] array, int first, int second) {
        int position = -1;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < array.length; i++) {
            if (array[i] > max) {
                max = array[i];
                position = i;
            }
        }
        int[] result = new int[array.length + 2];
        for (int i = 0; i < result.length; i++) {
            if (i < position) {
                result[i] = array[i];
            } else if (i == position) {
                result[i++] = first;
                result[i++] = array[i - 2];
                result[i] = second;
            } else {
                result[i] = array[i - 2];
            }
        }
        return result;
    }
}
