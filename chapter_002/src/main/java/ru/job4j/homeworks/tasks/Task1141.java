package ru.job4j.homeworks.tasks;

//11.41. Дан массив целых чисел. Вывести на экран сначала его четные элементы, затем нечетные.

public class Task1141 {
    public void printArrEvenThenNotEven(int[] array) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] % 2 == 0) {
                System.out.print(" " + array[i]);
            }
        }
        for (int i = 0; i < array.length; i++) {
            if (array[i] % 2 != 0) {
                System.out.print(" " + array[i]);
            }
        }
    }
}