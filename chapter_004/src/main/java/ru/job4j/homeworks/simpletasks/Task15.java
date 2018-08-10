package ru.job4j.homeworks.simpletasks;

//Задан числовой массив.
// Нужно реализовать метод кольцевого сдвига на N. int[] shift().
// Не использовать дополнительный массив.
// Например, [1, 2, 3, 4, 5] - shift(2) - [4, 5, 1, 2, 3]


public class Task15 {
    public int[] shift(int[] array, int count) {
        for (int i = 0; i < count; i++) {
            int num = array[array.length - 1];
            for (int j = array.length - 1; j > 0; j--) {
                array[j] = array[j - 1];
            }
            array[0] = num;
        }
        return array;
    }
}
