package ru.job4j.homeworks.tasks;

//11.141. В массиве а записаны измеренные в сотых долях секунды результаты
//        23 спортсменов в беге на 100 м. Составить команду из четырех лучших бе-
//        гунов для участия в эстафете 4 100 м, т. е. указать одну из четверок нату-
//        ральных чисел i, j, k, m, для которой 1 i < j < k < m 4 и сумма
//        ai + aj + ak + am имеет наименьшее значение.

import java.util.Arrays;

public class Task11141 {
    public int[] bestResults(int[] array, int number) {
        if (number > array.length) {
            number = array.length;
        }
        int count = 0;
        int[] result = new int[number];
        int[] speed = Arrays.copyOf(array, array.length);
        Arrays.sort(speed);
        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < array.length; j++) {
                if (array[j] == speed[i]) {
                    result[count++] = j + 1;
                    array[j] = -1;
                    break;
                }
            }
        }
        Arrays.sort(result);
        return result;
    }
}
