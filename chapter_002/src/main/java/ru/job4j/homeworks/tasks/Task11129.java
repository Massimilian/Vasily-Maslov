package ru.job4j.homeworks.tasks;

//11.129. Известен возраст группы людей в списке.
//        Какой человек указан в списке раньше:
//        самый старый или самый молодой?
//        (Должны учитываться первые из людей одинакового возраста.)

public class Task11129 {
    public String youngOrOld(int[] array) {
        String info;
        int young = Integer.MAX_VALUE;
        int old = -1;
        int youngPos = 0;
        int oldPos = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] < young) {
                young = array[i];
                youngPos = i;
            }
            if (array[i] > old) {
                old = array[i];
                oldPos = i;
            }
        }
        if (youngPos < oldPos) {
            info = "First is the most young";
        } else if (youngPos > oldPos) {
            info = "First is the most old";
        } else {
            info = "Young and old are equals";
        }
        return info;
    }
}
