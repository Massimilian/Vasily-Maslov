package ru.job4j.homeworks.tasks;

//11.107. Дан массив. Определить:
//        а) максимальный элемент;
//        б) минимальный элемент;
//        в) на сколько максимальный элемент больше минимального;
//        г) индекс максимального элемента;
//        д) индекс минимального и индекс максимального элементов.

public class Task11107 {
    public int[] getInfo(int[] array) {
        int[] result = new int[5]; // для краткости все ответы помещаю в массив: 0 - а), 1 - б), 2 - в), 3 и 4 - д).
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < array.length; i++) {
            if (array[i] > max) {
                max = array[i];
                result[0] = max;
                result[3] = i;
            }
            if (array[i] < min) {
                min = array[i];
                result[1] = min;
                result[4] = i;
            }
        }
        result[2] = result[0] - result[1];
        return result;
    }
}
