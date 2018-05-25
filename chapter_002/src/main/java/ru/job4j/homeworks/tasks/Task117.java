package ru.job4j.homeworks.tasks;

//11.7. Заполнить массив из двадцати элементов так, как представлено на рис. (20, 19, 18 ..., 1)

public class Task117 {
    public int[] easyNumbers() {
        return new int[]{20, 19, 18, 17, 16, 15, 14, 13, 12, 11, 10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
    }

    public int[] numbers(int size) { // улучшеный вариант с регулировкой размера массива
        int[] result = new int[size];
        for (int i = 0; i < size; i++) {
            result[i] = size - i;
        }
        return result;
    }
}
