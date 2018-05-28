package ru.job4j.homeworks.tasks;

//11.43. В массиве хранится информация о количестве осадков, выпавших за каж-дый день января.
//        Определить, в какие числа месяца осадков не было.

public class Task1143 {
    public int[] sunnyDays(int[] month) {
        int count = 0;
        for (int i = 0; i < month.length; i++) {
            if (month[i] == 0) {
                month[count++] = i + 1;
            }
        }
        int[] result = new int[count];
        for (int i = 0; i < result.length; i++) {
            result[i] = month[i];
        }
        return result;
    }
}
