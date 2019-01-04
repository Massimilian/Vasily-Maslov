package ru.job4j.homeworks.tasks;

//11.2. Заполнить массив из десяти элементов значениями, вводимыми с клавиатуры
//        в ходе выполнения программы.

import java.util.Scanner;

public class Task112 {
    Scanner scanner = new Scanner(System.in);
    int[] array = new int[10];

    public int[] method() {
        for (int i : array) {
            i = scanner.nextInt();
        }
        return this.array;
    }
}