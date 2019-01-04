package ru.job4j.homeworks.tasks;

//11.127. Известна численность каждого из 40 классов школы.
//        Верно ли, что в самом многочисленном классе учится на 10 учеников больше, чем в самом малочисленном?

public class Task11127 {
    public boolean classes(int[] array) {
        int max = -1;
        int min = Integer.MAX_VALUE;
        for (int i : array) {
            if (max < i) {
                max = i;
            }
            if (min > i) {
                min = i;
            }
        }
        return max == min + 10;
    }
}
