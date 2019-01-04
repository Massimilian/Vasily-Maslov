package ru.job4j.homeworks.tasks;

//11.146. Дан одномерный массив из 20 элементов.
// Переставить первые три и последние три элемента, сохранив порядок их следования.

public class Task11146 {
    public int[] changeElements(int[] array, int number) {
        if (number > array.length / 2) {
            number = array.length / 2;
        }
        for (int i = 0; i < number; i++) {
            array[i] = array[i] + array[array.length - number + i];
            array[array.length - number + i] = array[i] - array[array.length - number + i];
            array[i] = array[i] - array[array.length - number + i];
        }
        return array;
    }
}
