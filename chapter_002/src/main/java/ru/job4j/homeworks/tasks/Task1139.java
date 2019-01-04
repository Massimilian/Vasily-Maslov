package ru.job4j.homeworks.tasks;

//11.39. Дан массив. Напечатать:
//        а) второй, четвертый и т. д. элементы;
//        б) третий, шестой и т. д. элементы.

public class Task1139 {
    public void printArr(int[] array, int count) {
        if (count == 0) {
            System.out.println("Error!");
        }
        for (int i = count; i < array.length; i = i + count) {
            System.out.println(array[i]);
        }
    }
}
