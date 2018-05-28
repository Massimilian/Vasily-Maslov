package ru.job4j.homeworks.tasks;

//11.110. В массиве хранится информация о стоимости 1 килограмма 20 видов кон-фет.
//        Определить, сколько стоят самые дешевые конфеты.

public class Task11110 {
    public int minPrice(int[] price) {
        int result = Integer.MAX_VALUE;
        for (int i : price) {
            result = result > i ? i : result;
        }
        return result;
    }
}
