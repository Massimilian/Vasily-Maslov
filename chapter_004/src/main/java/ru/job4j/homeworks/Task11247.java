package ru.job4j.homeworks;

//Даны два массива одного размера, в которых нет нулевых элементов.
//        Получить третий массив, каждый элемент которого равен 1,
//        если элементы заданных массивов с тем же номером имеют одинаковый знак,
//        и равен нулю в противном случае.

import java.util.ArrayList;

public class Task11247 {
    public int[] resultMass(int[] one, int[] two) {
        int length = Math.min(one.length, two.length);
        int[] result = new int[length];
        for (int i = 0; i < result.length; i++) {
            result[i] = one[i] < 0 && two[i] < 0 || one[i] >= 0 && two[i] >= 0 ? 1 : 0;
        }
        return result;
    }

    public ArrayList resultArray(int[] one, int[] two) {
        ArrayList<Integer> result = new ArrayList<>();
        for (int i = 0; i < one.length; i++) {
            try {
                result.add(one[i] < 0 && two[i] < 0 || one[i] >= 0 && two[i] >= 0 ? 1 : 0);
            } catch (IndexOutOfBoundsException ioobe) {
                break;
            }
        }
        return result;
    }
}
