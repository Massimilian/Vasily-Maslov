package ru.job4j.homeworks.tasks;

//11.54. Дан массив. Найти:
//        а) сумму элементов массива, значение которых не превышает 20;
//        б) сумму элементов массива, больших числа a.

public class Task1154 {
    public int sumOfSmallNumbers(int[] array) {
        int result = 0;
        for (int i : array) {
            if (i <= 20) {
                result += i;
            }
        }
        return result;
    }

    public int sumOfBiggerNumbers(int[] array, int a) {
        int result = 0;
        for (int i : array) {
            if (i > a) {
                result += i;
            }
        }
        return result;
    }
}
