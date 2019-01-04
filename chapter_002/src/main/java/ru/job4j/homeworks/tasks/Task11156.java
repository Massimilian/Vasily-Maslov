package ru.job4j.homeworks.tasks;

//11.156. Удалить из массива:
//        а) все отрицательные элементы;
//        б) все элементы, большие данного числа n;
//        в) все элементы, начиная с n1-го по n2-й (n1 <= n2).

public class Task11156 {
    public int[] deleteAllSubzero(int[] array) {
        int[] result = new int[this.finder(array, Integer.MIN_VALUE, -1)];
        int count = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] >= 0) {
                result[count++] = array[i];
            }
        }
        return result;
    }

    public int[] deleteAllBiggerThen(int[] array, int point) {
        int[] result = new int[this.finder(array, point + 1, Integer.MAX_VALUE)];
        int count = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] <= point) {
                result[count++] = array[i];
            }
        }
        return result;
    }


    public int[] deleteNumbersBetween(int[] array, int minimal, int maximal) {
        int[] result = new int[this.finder(array, minimal + 1, maximal - 1)];
        int count = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] <= minimal || array[i] >= maximal) {
                result[count++] = array[i];
            }
        }
        return result;
    }


    private int finder(int[] array, int smallest, int biggest) {
        int count = 0;
        for (int i : array) {
            if (i <= biggest && i >= smallest) {
                count++;
            }
        }
        return array.length - count;
    }
}
