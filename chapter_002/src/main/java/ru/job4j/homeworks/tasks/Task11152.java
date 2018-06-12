package ru.job4j.homeworks.tasks;

//11.152. В массиве записана информация о росте каждого из 25 учеников класса (в порядке уменьшения роста).
//        Один из учеников из класса выбыл. Получить новый массив с упорядоченными в том же порядке данными о росте оставшихся учеников.
//        Рассмотреть два возможных случая:
//        1) известен порядковый номер выбывшего ученика;
//        2) известен рост выбывшего ученика.

public class Task11152 {
    public int[] minusPupilByPoint(int[] pupils, int point) {
        int[] result = new int[pupils.length - 1];
        for (int i = 0; i < pupils.length; i++) {
            if (i < point - 1) {
                result[i] = pupils[i];
            }
            if (i > point - 1) {
                result[i - 1] = pupils[i];
            }
        }
        return result;
    }

    public int[] minusPupilByHeight(int[] pupils, int height) {
        int test = 0;
        int point = -1;
        for (int i = 0; i < pupils.length; i++) {
            if (height == pupils[i]) {
                test++;
                point = i + 1;
            }
        }
        if (test != 1) {
            System.out.println("Please refine your ask.");
        } else {
            pupils = this.minusPupilByPoint(pupils, point);
        }
        return pupils;
    }
}
