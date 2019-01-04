package ru.job4j.homeworks.tasks;

//11.111. В массиве хранится информация о результатах 25 спортсменов, участвовав-ших в лыжной гонке.
//        Определить результат спортсмена-победителя гонки.

public class Task11111 {
    public int resultArray(int[] sport) {
        //int bestResult = Integer.MAX_VALUE;
        int bestResult = Integer.MAX_VALUE;
        for (int i = 0; i < sport.length; i++) {
            if (bestResult > sport[i]) {
                bestResult = sport[i];
            }
        }
        return bestResult;
    }
}
