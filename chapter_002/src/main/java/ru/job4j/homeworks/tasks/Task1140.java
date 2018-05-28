package ru.job4j.homeworks.tasks;

//11.40. Дан массив. Вывести на экран сначала его неотрицательные элементы, за-тем отрицательные.

public class Task1140 {
    public void sortedArr(int[] array) {
        int[] result = new int[array.length];
        int count = -1;
        for (int i = 0; i < array.length; i++) {
            if (array[i] > 0) {
                result[++count] = array[i];
            }
        }
        for (int i = 0; i < array.length; i++) {
            if (array[i] == 0) {
                result[++count] = 0;
            }
        }
        for (int i = 0; i < array.length; i++) {
            if (array[i] < 0) {
                result[++count] = array[i];
            }
        }
        for (int i: result) {
            System.out.print(" " + i);
        }
        System.out.println(".");
    }
}
