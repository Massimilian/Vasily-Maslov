package ru.job4j.homeworks.tasks;

//11.109. В массиве хранится информация о стоимости каждой из 50 марок легковых автомобилей.
//        Определить, сколько стоит самый дорогой автомобиль.

public class Task11109 {
    public int biggestPrice(int[] values) {
        int result = 0;
        for (int i : values) {
            result = result < i ? i : result;
        }
        return result;
    }
}
