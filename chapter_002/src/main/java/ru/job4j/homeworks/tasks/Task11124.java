package ru.job4j.homeworks.tasks;

//11.124. Дан массив. Найти номера всех элементов:
//        а) с минимальным значением;
//        б) с максимальным значением.

public class Task11124 {
    public int[][] maxMinSearch(int[] array) {
        return new int[][]{this.min(array), this.max(array)};
    }

    private int[] min(int[] array) {
        int min = Integer.MAX_VALUE;
        int[] res = new int[array.length];
        int count = 0;
        for (int i = 0; i < array.length; i++) {
            if (min > array[i]) {
                min = array[i];
                count = 0;
                res[count] = i;
            } else if (min == array[i]) {
                res[++count] = i;
            }
        }
        int[] result = new int[++count];
        for (int i = 0; i < count; i++) {
            result[i] = res[i] + 1;
        }
        return result;
    }

    private int[] max(int[] array) {
        int max = Integer.MIN_VALUE;
        int[] res = new int[array.length];
        int count = 0;
        for (int i = 0; i < array.length; i++) {
            if (max < array[i]) {
                max = array[i];
                count = 0;
                res[count] = i;
            } else if (max == array[i]) {
                res[++count] = i;
            }
        }
        int[] result = new int[++count];
        for (int i = 0; i < count; i++) {
            result[i] = res[i] + 1;
        }
        return result;
    }
}
