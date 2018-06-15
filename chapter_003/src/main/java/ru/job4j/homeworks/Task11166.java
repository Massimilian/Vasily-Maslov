package ru.job4j.homeworks;

//11.166. Данные о росте 25 учеников класса, упорядоченные по убыванию, записаны в массиве.
//        В начале учебного года в класс поступили два новых ученика. Получить аналогичный массив, учитывающий рост новых учеников.
//        Рассмотреть два возможных случая:
//        1) известны порядковые номера новых учеников;
//        2) известны значения роста новых учеников.

import java.util.Arrays;

public class Task11166 {
    public int[] addByNumber(int[] array, int[][] pupils) {
        int[] result = new int[array.length + pupils.length];
        int count = 0;
        int resCount = 0;
        for (int i = 0; i < array.length; i++) {
                while (count < pupils.length && i >= pupils[count][0]) {
                    result[resCount++] = pupils[count][1];
                    count++;
                }
            result[resCount++] = array[i];
        }
        return result;
    }

    public int[] addByHeight(int[] array, int[] pupils) {
        int[] result = new int[array.length + pupils.length];
        for (int i = 0; i < array.length; i++) {
            result[i] = array[i];
        }
        for (int i = array.length; i < result.length; i++) {
            result[i] = pupils[i - array.length];
        }
        Arrays.sort(result);
        for (int i = 0; i < result.length / 2; i++) {
            result[i] += result[result.length - 1 - i];
            result[result.length - 1 - i] = result[i] - result[result.length - 1 - i];
            result[i] = result[i] - result[result.length - 1 - i];
        }
        return result;
    }


}
