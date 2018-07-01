package ru.job4j.homeworks;

//11.237. Из элементов массива m сформировать массив n того же размера по правилу:
//        если номер i элемента массива m нечетный, то n(i) = i*m(i) , в противном случае n(i) = m(i).

import java.util.ArrayList;

public class Task11237 {
    public int[] makeArray(int[] array) {
        for (int i = 2; i < array.length; i++) {
            array[i] = i % 2 == 0 ? array[i] : array[i] * i;
        }
        return array;
    }

    public ArrayList<Integer> makeList(ArrayList<Integer> list) {
        boolean isEven = true;
        for (int i = 2; i < list.size(); i++) {
            if (i % 2 != 0) {
                list.set(i, list.get(i) * i);
            }
        }
        return list;
    }
}
