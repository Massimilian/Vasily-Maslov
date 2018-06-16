package ru.job4j.homeworks;

//11.169. Переставить первый элемент массива на место последнего.
// При этом второй, третий, ..., последний элементы сдвинуть влево на 1 позицию.

public class Task11169 {
    public int[] replaceElement(int[] array, int count) {
        if (count > array.length || count <= 0) {
            count = array.length;
        }
        int[] result = new int[array.length];
        result[array.length - 1] = array[count - 1];
        for (int i = 0; i < array.length - 1; i++) {
            result[i] = count - 1 > i ? array[i] : array[i + 1];
        }
        return result;
    }
}
