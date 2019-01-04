package ru.job4j.homeworks.tasks;

//11.38. Дан массив натуральных чисел. Напечатать:
//        а) все элементы массива, являющиеся двузначными числами;
//        б) все элементы массива, являющиеся трехзначными числами.

public class Task1138 {
    public int[] arrNumbers(int[] array, int num) {
        int count = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] < (int) Math.pow(10, num) && array[i] > (int) Math.pow(10, (num - 1)) - 1) {
                array[count] = array[i];
                count++;
            }
        }
        int[] result = new int[count];
        for (int i = 0; i < result.length; i++) {
            result[i] = array[i];
        }
        return result;
    }
}
