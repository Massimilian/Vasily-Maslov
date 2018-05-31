package ru.job4j.homeworks.tasks;

//11.115. В массиве хранится информация о максимальной скорости каждой из 40 марок легковых автомобилей.
//        Определить порядковый номер самого быстрого автомобиля.
//        Если таких автомобилей несколько, то должен быть найден номер:
//        а) первого из них;
//        б) последнего из них.

public class Task11115 {
    public int maxSpeedy(int[] cars) {
        int result = 0;
        int speed = -1;
//        for (int i = cars.length; i > 0; i--) {
//        вариант для последней из списка машин
        for (int i = 0; i < cars.length; i++) {
            if (speed < cars[i]) {
                speed = cars[i];
                result = i + 1;
            }
        }
        return result;
    }

//    Вариант для возврата списка машин (на всякий случай)
    public int[] allSpeedyCars(int[] cars) {
        int[] mediumResult = new int[cars.length];
        int speed = -1;
        int count = 0;
        for (int i = 0; i < cars.length; i++) {
            if (speed < cars[i]) {
                speed = cars[i];
                count = 0;
                mediumResult[count++] = i;
            } else if (speed == cars[i]) {
                mediumResult[count++] = i;
            }
        }
        int[] result = new int[count];
        for (int i = 0; i < count; i++) {
            result[i] = mediumResult[i] + 1;
        }
        return result;
    }
}
