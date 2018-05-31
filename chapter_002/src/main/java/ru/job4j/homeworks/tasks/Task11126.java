package ru.job4j.homeworks.tasks;

//11.126. Известен вес каждого человека из группы.
//        Верно ли, что вес самого тяжелого из них превышает массу самого легкого более чем в 2 раза?

public class Task11126 {
    public boolean weights(int[] array) {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int i : array) {
            if (max < i) {
                max = i;
            }
            if (min > i) {
                min = i;
            }
        }
        return max > min * 2;
    }
}
