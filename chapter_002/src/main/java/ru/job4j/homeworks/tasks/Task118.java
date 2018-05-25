package ru.job4j.homeworks.tasks;

//11.8. Заполнить массив из восьми элементов таким образом, чтобы значения эле-
//      ментов при просмотре массива слева направо образовывали:
//        а) убывающую последовательность;
//        б) возрастающую последовательность.
//        Варианты, представленные в задачах 11.6 и 11.7, не использовать.

public class Task118 {
    private int size = 8;

    public int[] arrayMinus(int position) {
        int[] result = new int[this.size];
        for (int i = 0; i < this.size; i++) {
            result[i] = position - i;
        }
        return result;
    }

    public int[] arrayPlus(int position) {
        int[] result = new int[this.size];
        for (int i = 0; i < this.size; i++) {
            result[i] = position + i;
        }
        return result;
    }
}
