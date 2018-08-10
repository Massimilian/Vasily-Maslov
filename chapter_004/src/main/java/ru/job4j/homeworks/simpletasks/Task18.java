package ru.job4j.homeworks.simpletasks;

// Задан двойной массив, заполненный нулями и единицами.
// Нужно определить самое большое множество единиц.
// Множеством считается объединение единиц, которые соприкасаются друг с другом.
// Диагональное соприкосновение не учитывать.

public class Task18 {
    public int numberOfNums(int[][] array, int num) {
        int count = 0;
        int newCount = 1;
        for (int[] strings : array) {
            for (int j = 0; j < strings.length - 1; j++) {
                newCount = strings[j] == strings[j + 1] && strings[j] == num ? newCount + 1 : 1;
                count = newCount > count ? newCount : count;
            }
        }
        return count;
    }
}
