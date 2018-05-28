package ru.job4j.homeworks.tasks;

//11.42. Дан массив целых чисел. Найти номера элементов, оканчивающихся циф-рой 0 (известно, что такие элементы в массиве есть).

public class Task1142 {
    public int[] findZeroNumbers(int[] array) {
        int count = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] % 10 == 0) {
                array[count++] = i + 1;
            }
        }
        int[] result = new int[count];
        for (int i = 0; i < result.length; i++) {
            result[i] = array[i];
        }
        return result;
    }
}
