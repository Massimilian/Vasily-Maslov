package ru.job4j.homeworks;

//11.190.*Найти количество различных элементов в массиве.

public class Task11190 {
    public int numberOfDiffElements(int[] array) {
        int count = array.length;
        boolean repeated = false;
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[i] == array[j]) {
                    repeated = true;
                    count--;
                }
            }
            if (repeated) {
                count--;
                repeated = false;
            }
        }
        return count;
    }
}
