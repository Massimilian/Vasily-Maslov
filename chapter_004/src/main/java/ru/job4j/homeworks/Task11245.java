package ru.job4j.homeworks;

//11.245.*Дан массив. Переписать его элементы в другой массив такого же размера
//        следующим образом: сначала должны идти все отрицательные элементы,
//        а затем все остальные. Использовать только один проход по исходному
//        массиву.

import java.util.ArrayList;

public class Task11245 {
    public int[] minusAndPlus(int[] array) {
        int count = 0;
        int backCount = array.length - 1;
        int[] result = new int[array.length];
        for (int number : array) {
            if (number < 0) {
                result[count++] = number;
            } else {
                result[backCount--] = number;
            }
        }
        return result;
    }

    public ArrayList<Integer> minusAndPlus(ArrayList<Integer> list) {
        ArrayList<Integer> result = (ArrayList<Integer>) list.clone();
        int count = 0;
        int backCount = list.size() - 1;
        for (Integer number : list) {
            if (number < 0) {
                result.set(count++, number);
            } else {
                result.set(backCount--, number);
            }
        }
        return result;
    }
}
