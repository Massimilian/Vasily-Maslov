package ru.job4j.homeworks;

//11.170. Переставить первый элемент массива на место k-го элемента.
//        При этом второй, третий, ..., k-й элементы сдвинуть влево на 1 позицию.

public class Task11170 {
    public int[] changeArray(int[] array, int startPos, int finalPos) {
        int temp = array[startPos - 1];
        for (int i = startPos - 1; i < finalPos; i++) {
            array[i] = array[i+1];
        }
        array[finalPos - 1] = temp;
        return array;
    }
}
