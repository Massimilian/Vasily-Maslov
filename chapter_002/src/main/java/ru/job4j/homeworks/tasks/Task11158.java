package ru.job4j.homeworks.tasks;

//11.158.*Удалить из массива все повторяющиеся элементы, оставив их первые вхождения,
//        т. е. в массиве должны остаться только различные элементы.

public class Task11158 {
    public int[] deleteDubles(int[] array) {
        int count = 0;
        boolean isCrossed = false;
        int[] mediumResult = new int[array.length];
        for (int i = array.length - 1; i >= 0; i--) {
            for (int j = array.length - 1; j >= 0; j--) {
                if (i == j) {
                    continue;
                }
                if (array[i] == array[j]) {
                    isCrossed = true;
                    break;
                }
            }
            if (!isCrossed) {
                mediumResult[count++] = array[i];
            }
            isCrossed = false;
        }
        int[] result = new int[count];
        for (int i = 0; i < result.length; i++) {
            result[i] = mediumResult[(count--) - 1];
        }
        return result;
    }
}
