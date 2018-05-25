package ru.job4j.homeworks.tasks;

//11.6. Заполнить массив из двенадцати элементов так, как показано на рис. (1, 2, 3, ..., 12).

public class Task116 {
    public int[] easyNumbers() {
        return new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12};
    }

    public int[] numbers() {
        int[] result = new int[12];
        for (int i = 0; i < result.length; i++) {
            result[i] = i + 1;
        }
        return result;
    }
}
