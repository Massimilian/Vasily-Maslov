package ru.job4j.homeworks.tasks;

//11.142.*Изменить знак у максимального по модулю элемента массива. Минималь-
//        ный элемент массива при этом не определять.

public class Task11142 {
    public int[] specialChange(int[] array) {
        int res = -1;
        int point = 0;
        for (int i = 0; i < array.length; i++) {
            if (Math.abs(array[i]) > res) {
// максимальных по модулю может быть несколько. Тогда условие выглядит так: if (Math.abs(i) >= res) {
                res = Math.abs(array[i]);
                point = i;
            }
        }
        array[point] = -1 * array[point];
        return array;
    }
}
