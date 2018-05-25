package ru.job4j.homeworks.tasks;

//11.36. Дан массив. Напечатать:
//        а) все неотрицательные элементы;
//        б) все элементы, не превышающие число 100.

public class Task1136 {
    public void allPositive(int[] numbers) {
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] >= 0) {
                System.out.print(numbers[i] + " ");
            }
        }
    }

    public void hundredMinus(int[] numbers) {
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] < 100) {
                System.out.print(numbers[i] + " ");
            }
        }
    }
}
