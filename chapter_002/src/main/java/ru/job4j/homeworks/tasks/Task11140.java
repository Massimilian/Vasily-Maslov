package ru.job4j.homeworks.tasks;

//11.140. В массиве хранится информация о среднедневной температуре за каждый
//        день февраля. Определить даты двух самых холодных дней.
//        П р и м е ч а н и е
//        Задачу решить, не используя два прохода по массиву.

import java.util.Arrays;

// метод для двух дней (согласно ТЗ)
public class Task11140 {
    public int[] mostColdDays(int[] array) {
        int firstTemp = Integer.MAX_VALUE;
        int secondTemp = Integer.MAX_VALUE;
        int firstDay = -1;
        int secondDay = -1;
        for (int i = 0; i < array.length; i++) {
            if (array[i] < firstTemp && firstTemp == secondTemp) {
                firstTemp = array[i];
                firstDay = i + 1;
            }
            if (array[i] < firstTemp && firstTemp != secondTemp) {
                secondTemp = firstTemp;
                firstTemp = array[i];
                secondDay = firstDay;
                firstDay = i + 1;
            }
        }
        return new int[]{firstDay, secondDay};
    }

// метод для рандомного количества дней.
    public int[] mostColdDays(int[] array, int days) {
        if (array.length < days) {
            days = array.length;
        }
        int[] coldDays = new int[days];
        int[] temp = new int[days];
        for (int i = 0; i < temp.length; i++) {
            temp[i] = Integer.MAX_VALUE;
        }
        for (int i = 0; i < array.length; i++) {
            for (int j = temp.length - 1; j >= 0; j--) {
                if (array[i] < temp[j]) {
                    temp[j] = array[i];
                    Arrays.sort(temp);
                    break;
                }
            }
        }
        int count = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < temp.length; j++) {
                if (array[i] == temp[j]) {
                    temp[j] = Integer.MAX_VALUE;
                    coldDays[count++] = i + 1;
                    break;
                }
            }
        }
        Arrays.sort(coldDays);
        return coldDays;
    }
}
