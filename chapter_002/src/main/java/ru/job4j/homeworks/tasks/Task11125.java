package ru.job4j.homeworks.tasks;

//11.125. Дан массив вещественных чисел. Выяснить:
//        а) верно ли, что максимальный элемент превышает минимальный не более чем на 25;
//        б) верно ли, что минимальный элемент меньше максимального более чем в 2 раза.

public class Task11125 {
    public boolean[] getAnswers(int[] array) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int i : array) {
            if (min > i) {
                min = i;
            }
            if (max < i) {
                max = i;
            }
        }
        boolean[] answers = new boolean[2];
        answers[0] = min >= max - 25 ? true : false;
        answers[1] = min > max / 2 ? false : true;
        return answers;
    }
}
