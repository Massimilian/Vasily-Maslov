package ru.job4j.homeworks.tasks;

//11.157. Дан массив целых чисел. Удалить из него:
//        а) все четные элементы, стоящие на нечетных местах;
//        б) все элементы, кратные 3 или 5.

public class Task11157 {
    public int[] deleteAllEvenOnAntiEvenPlaces(int[] array) {
        int count = 0;
        for (int i = 0; i < array.length; i += 2) {
            if (array[i] % 2 == 0 && array[i] != 0) {
                count++;
            }
        }
        int[] result = new int[array.length - count];
        count = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] % 2 != 0 || array[i] == 0 || array[i] % 2 == 0 && i % 2 == 0) {
                result[i - count] = array[i];
            } else {
                count++;
            }
        }
        return result;
    }

    public int[] deleteAllChangedDivisible(int[] array, int[] numbers) {
        int[] mediumResult = new int[array.length];
        int count = 0;
        boolean isDivisible = false;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < numbers.length; j++) {
                if (array[i] % numbers[j] == 0 && array[i] != 0) {
                    isDivisible = true;
                    break;
                }
            }
            if (!isDivisible) {
                mediumResult[count++] = array[i];
            } else {
                isDivisible = false;
            }
        }
        int[] result = new int[count];
        for (int i = 0; i < result.length; i++) {
            result[i] = mediumResult[i];
        }
        return result;
    }
}
