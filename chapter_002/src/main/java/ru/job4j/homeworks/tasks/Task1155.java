package ru.job4j.homeworks.tasks;

//11.55. Дан массив целых чисел. Найти:
//        а) сумму нечетных элементов;
//        б) сумму элементов, кратных заданному числу;
//        в) сумму элементов массива, кратных a или b.

public class Task1155 {
    public int sumOfNotSomeNumbers(int[] array, int a, int b) { // Для поиска суммы нечётных элементов a == 2.
        int result = 0;
        for (int i = 0; i < array.length; i++) {
            int x = array[i] % a;
            int y = array[i] % b;
            result = array[i] % a == 0 && array[i] % b == 0 ? result + array[i] : result; // для выполнения условия б) надо убрать array[i] % b == 0

        }
        return result;
    }
}
