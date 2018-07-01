package ru.job4j.homeworks;

//11.236. Из элементов массива a сформировать массив b того же размера по правилу:
//        если номер i элемента массива a четный, то b = a*a , в противном случае b = 2a.

import org.hamcrest.Matcher;

import java.util.ArrayList;
import java.util.List;

public class Task11236 {
    public int[] editArray(int[] array) {
        boolean isEven = false;
        for (int i = 1; i < array.length; i++) {
            if (isEven) {
                array[i] *= array[i];
                isEven = false;
            } else {
                array[i] *= 2;
                isEven = true;
            }
        }
        return array;
    }

    public ArrayList<Integer> editList(ArrayList<Integer> list) {
        if (list.size() > 1) {
            list.set(1, list.get(1) * 2);
        }
        for (int i = 2; i < list.size(); i++) {
            if (i % 2 == 0) {
                list.set(i, (int) Math.pow(list.get(i), 2));
            } else {
                list.set(i, list.get(i) * 2);
            }
        }
        return list;
    }
}
