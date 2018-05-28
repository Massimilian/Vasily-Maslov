package ru.job4j.homeworks.tasks;

//11.58. Известны данные о количестве осадков, выпавших за каждый месяц года.
//        Найти общее число осадков, выпавших в марте, июне, сентябре и декабре.

public class Task1158 {
    public int yearRainInfo(int[] year, int[] monthes) {
        int result = 0;
        for (int i = 0; i < monthes.length; i++) {
            result += year[monthes[i] - 1];
        }
        return result;
    }
}
