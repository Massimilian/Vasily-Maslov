package ru.job4j.homeworks.tasks;

//11.56. Определить сумму второго, четвертого, шестого и т. д. элементов массива.

public class Task1156 {
    public int sumOfSomeNumbers(int[] array, int coff) {
        int result = 0;
        for (int i = coff; i < array.length; i += coff) {
            result += array[i];
        }
        return result;
    }
}
