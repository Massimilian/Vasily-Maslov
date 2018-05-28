package ru.job4j.homeworks.tasks;

//11.108. В массиве хранится информация о количестве страниц в каждой из 100 книг.
//        Все страницы имеют одинаковую толщину.
//        Определить количество страниц в самой толстой книге.

public class Task11108 {
    public int findTheBiggest(int[] array) {
        int result = Integer.MIN_VALUE;
        for (int i : array) {
            result = i > result ? i : result;
        }
        return result;
    }
}
