package ru.job4j.homeworks.tasks;

//11.164. Вставить заданное число в массив целых чисел:
//        а) перед всеми элементами, кратными числу a;
//        б) после всех отрицательных элементов.
//        Каким должен быть максимальный размер исходного массива в обоих случаях?

public class Task11164 {
    public int[] numbers(int[] array, int a, int checkPoint) {
        int[] result = new int[array.length * 2];
        int count = 0;
        if (a == 0) {
            System.out.println("Error!");
        } else {
            for (int i = 0; i < array.length; i++) {
                if (array[i] % a == 0) {
                    result[i + count] = checkPoint;
                    count++;
                    result[i + count] = array[i];
                } else {
                    result[i + count] = array[i];
                }
            }
        }
        return this.checkArray(result, array.length + count);
    }

    public int[] numbersMinusVersion(int[] array, int checkPoint) {
        int[] result = new int[array.length * 2];
        int count = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] < 0) {
                result[i + count] = array[i];
                count++;
                result[i + count] = checkPoint;
            } else {
                result[i + count] = array[i];
            }
        }
        return this.checkArray(result, array.length + count);
    }

    public int[] checkArray(int[] array, int count) {
        int[] result = new int[count];
        for (int i = 0; i < result.length; i++) {
            result[i] = array[i];
        }
        return result;
    }
}
