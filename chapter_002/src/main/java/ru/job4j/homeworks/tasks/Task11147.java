package ru.job4j.homeworks.tasks;

//11.147. Дан одномерный массив из 15 элементов. Переставить в обратном порядке:
//        а) элементы, расположенные между вторым и десятым элементами (т. е. с третьего по девятый);
//        б) элементы, расположенные между k-м и s-м элементами (т. е. с (k + 1)-го по (s – 1)-й).
//        Значения k и s вводятся с клавиатуры, k < s;
//        в) элементы, расположенные между максимальным и минимальным эле-ментами, включая их.

public class Task11147 {
    public int[] changeElements(int[] array, int pos, int fin) {
        if (pos > fin) {
            pos = pos + fin;
            fin = pos - fin;
            pos = pos - fin;
        }
        pos--;
        fin--;
        for (int i = 0; i < array.length / 2; i++) {
            array[pos] = array[pos] + array[fin];
            array[fin] = array[pos] - array[fin];
            array[pos] = array[pos] - array[fin];
            pos++;
            fin--;
            if (pos == fin || pos == fin - 1 || pos == fin + 1) {
                break;
            }
        }
        return array;
    }

    public int[] changeElementsBetweenMaxMin(int[] array) {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        int maxPos = 0;
        int minPos = 0;
        for (int i = 0; i < array.length; i++) {
            if (max < array[i]) {
                max = array[i];
                maxPos = i;
            }
            if (min > array[i]) {
                min = array[i];
                minPos = i;
            }
        }
        return this.changeElements(array, ++minPos, ++maxPos);
    }
}
