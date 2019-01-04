package ru.job4j.homeworks.tasks;

//11.37. Дан массив целых чисел. Напечатать:
//        а) все четные элементы;
//        б) все элементы, оканчивающиеся нулем.

public class Task1137 {
    public void evenNumbers(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % 2 == 0) {
                System.out.println(arr[i] + " ");
            }
        }
    }

    public void endWithZero(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % 10 == 0) {
                System.out.print(arr[i] + " ");
            }
        }
    }
}
