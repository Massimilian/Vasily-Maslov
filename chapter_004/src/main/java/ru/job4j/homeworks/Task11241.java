package ru.job4j.homeworks;

//11.241. Дан массив. Переписать его второй, четвертый и т. д. элементы в другой массив такого же размера:
//        а) расположив элементы на тех же местах, что и в исходном массиве;
//        б) расположив элементы подряд с начала массива.

import java.util.ArrayList;

public class Task11241 {
    public int[] completeArrayWithNulls(int[] array) {
        int[] result = new int[array.length];
        if (array.length > 1) {
            for (int i = 1; i < array.length; i += 2) {
                result[i] = array[i];
            }
        }
        return result;
    }

    public int[] completeFullArray(int[] array) {
        int[] result = new int[array.length / 2];
        int count = 0;
        if (array.length > 1) {
            for (int i = 1; i < array.length; i += 2) {
                result[count++] = array[i];
            }
        }
        return result;
    }

    public ArrayList<Integer> completeArrayWithNulls(ArrayList<Integer> list) {
        ArrayList<Integer> result = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            if (i % 2 == 0) {
                result.add(0);
            } else {
                result.add(list.get(i));
            }
        }
        return result;
    }

    public ArrayList<Integer> completeFullArray(ArrayList<Integer> list) {
        ArrayList<Integer> result = new ArrayList<>();
        for (int i = 1; i < list.size(); i += 2) {
            result.add(list.get(i));
        }
        return result;
    }
}
