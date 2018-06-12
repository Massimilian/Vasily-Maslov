package ru.job4j.homeworks.tasks;

//11.153. Удалить из массива:
//        а) первый отрицательный элемент (если отрицательные элементы в массиве есть);
//        б) удалить последний четный элемент (если четные элементы в массиве есть).

public class Task11153 {
    public int[] deleteFirstSubzero(int[] array) {
        int[] result = new int[array.length - 1];
        boolean wasFirst = false;
        for (int i = 0; i < array.length; i++) {
            if (array[i] < 0 && !wasFirst) {
                wasFirst = true;
            } else if (!wasFirst && i != array.length - 1) {
                result[i] = array[i];
            } else if (wasFirst) {
                result[i - 1] = array[i];
            } else {
                break;
            }
        }
        return this.checkResult(array, result, wasFirst);
    }

    public int[] deleteLastEven(int[] array) {
        int[] result = new int[array.length - 1];
        boolean wasEven = false;
        for (int i = array.length - 1; i >= 0; i--) {
            if (array[i] % 2 == 0 && !wasEven && array[i] != 0) {
                wasEven = true;
            } else if (!wasEven && i != 0) {
                result[i - 1] = array[i];
            } else if (wasEven) {
                result[i] = array[i];
            } else {
                break;
            }
        }
        return this.checkResult(array, result, wasEven);
    }

    private int[] checkResult(int[] firstVariation, int[] secondVariation, boolean choice) {
        return choice ? secondVariation : firstVariation;
    }
}
