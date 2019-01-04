package ru.job4j.homeworks.tasks;

//11.144. Дан массив. Поменять местами:
//        а) второй и пятый элементы;
//        б) m-й и n-й элементы;
//        в) третий и максимальный элементы.
//        Если элементов с максимальным зна-чением несколько,
//        то в обмене должен участвовать первый из них;
//        г) первый и минимальный элементы.
//        Если элементов с минимальным зна-чением несколько,
//        то в обмене должен участвовать последний из них.

public class Task11144 {
    public int[] arrayChangeElements(int[] array, int m, int n) {
        m = correction(array.length, m);
        n = correction(array.length, n);
        array[m] = array[n] + array[m];
        array[n] = array[m] - array[n];
        array[m] = array[m] - array[n];
        return array;
    }

    public int correction(int max, int ask) {
        if (ask >= max) {
            ask = max - 1;
        }
        return ask;
    }

    public int[] arrayChangeMaxAndChanged(int[] array, int element) {
        int max = Integer.MIN_VALUE;
        int position = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] > max) {
                max = array[i];
                position = i;
            }
        }
        array = this.arrayChangeElements(array, array[element], array[position]);
        return array;
    }

    public int[] arrayChangeLastMinAndChanged(int[] array, int element) {
        int min = Integer.MAX_VALUE;
        int position = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] <= min) {
                min = array[i];
                position = i;
            }
        }
        array = this.arrayChangeElements(array, array[position], array[element]);
        return array;
    }
}
