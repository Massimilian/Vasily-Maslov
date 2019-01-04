package ru.job4j.homeworks.tasks;

//11.148. Поменять местами первый отрицательный и последний положительный элементы массива.
//        Учесть возможность того, что отрицательных или положительных элементов в массиве может не быть.

public class Task11148 {
    public int[] changeFirstPlusMinusElements(int[] array) {
        int plusPos = 0;
        int minusPos = 0;
        boolean minusInterrupter = true;
        for (int i = 0; i < array.length; i++) {
            if (array[i] > 0) {
                plusPos = i;
            }
            if (minusInterrupter && array[i] < 0) {
                minusPos = i;
                minusInterrupter = false;
            }
        }
        if (minusInterrupter || plusPos == 0) {
            System.out.println("This array can't be changed!");
        } else {
            array[plusPos] = array[plusPos] + array[minusPos];
            array[minusPos] = array[plusPos] - array[minusPos];
            array[plusPos] = array[plusPos] - array[minusPos];
        }
        return array;
    }
}
