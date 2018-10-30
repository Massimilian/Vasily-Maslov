package ru.job4j.homeworks;

//12.118. Дан двумерный массив целых чисел.
//        а) Составить программу, определяющую, верно ли, что сумма элементов строки массива
//        с известным номером оканчивается цифрой 0.
//        б) Определить, является ли сумма элементов второго столбца массива нечетным числом.

public class Task12118 {
    public boolean finalOfSumIsZero(int[][] array, int string) {
        int sum = 0;
        for (int i = 0; i < array[string].length; i++) {
            sum += array[string][i];
        }
        return sum % 10 == 0;
    }

    public boolean sumIsNotEven(int[][] array, int string) {
        int sum = 0;
        for (int i = 0; i < array[string].length; i++) {
            sum += array[string][i];
        }
        return sum % 2 != 0 && sum != 0;
    }
}
