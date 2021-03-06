package ru.job4j.homeworks.tasks;

//11.122. В массиве хранится информация о стоимости каждой из 60 книг.
//        Определить количество самых дешевых книг.
//        Примечание:
//        Задачу решить, не используя два прохода по массиву.

public class Task11122 {
    public int howMuchCheapBooks(int[] books) {
        int result = 1;
        int price = Integer.MAX_VALUE;
        for (int book : books) {
            if (price > book) {
                price = book;
                result = 1;
            } else if (price == book) {
                result++;
            }
        }
        return result;
    }
}
