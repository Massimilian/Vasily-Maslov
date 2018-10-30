package ru.job4j.homeworks;

//12.153. Дан двумерный массив целых чисел. Определить:
//        а) есть ли в нем столбец, состоящий только из нулей;
//        б) есть ли в нем столбец, состоящий только из элементов, принадлежащих
//        промежутку от 0 до b;
//        в) есть ли в нем столбец, состоящий только из четных элементов;
//        г) есть ли в нем столбец, в котором равное количество положительных
//        и отрицательных элементов;
//        д) есть ли в нем столбец, в котором имеются одинаковые элементы;
//        е) есть ли в нем столбец, в котором имеются как минимум три элемента, яв
//        ляющиеся минимальными в массиве.

import java.util.*;

public class Task12153 {
    public boolean hasColumnWithOnlyNumber(int[][] array, int number) {
        boolean result = false;
        for (int i = 0; i < array[0].length; i++) {
            if (result) {
                break;
            }
            result = true;
            for (int j = 0; j < array.length; j++) {
                if (array[j][i] != number) {
                    result = false;
                    break;
                }
            }
        }
        return result;
    }

    public boolean hasColumnWithOnlySomeNumbers(int[][] array, int smallNumber, int bigNumber) {
        boolean result = false;
        for (int i = 0; i < array[0].length; i++) {
            if (result) {
                break;
            }
            result = true;
            for (int j = 0; j < array.length; j++) {
                if (array[j][i] >= smallNumber && array[j][i] <= bigNumber) {
                    result = false;
                    break;
                }
            }
        }
        return result;
    }

    public boolean hasColumnWithOnlyEvens(int[][] array) {
        boolean result = false;
        for (int i = 0; i < array[0].length; i++) {
            if (result) {
                break;
            }
            result = true;
            for (int j = 0; j < array.length; j++) {
                if (array[j][i] % 2 != 0 && array[j][i] != 0) {
                    result = false;
                    break;
                }
            }
        }
        return result;
    }

    public boolean hasColumnWithEqualNumberOfPositiveAndSubzero(int[][] array) {
        boolean result = false;
        int positives;
        int subzero;
        for (int i = 0; i < array[0].length; i++) {
            positives = 0;
            subzero = 0;
            for (int j = 0; j < array.length; j++) {
                if (array[j][i] > 0) {
                    positives++;
                }
                if (array[j][i] < 0) {
                    subzero++;
                }
            }
            if (positives == subzero) {
                result = true;
                break;
            }
        }
        return result;
    }


    public boolean hasColumnWithEquals(int[][] array) {
        boolean result = false;
        for (int i = 0; i < array[0].length; i++) {
            for (int j = 0; j < array.length - 1; j++) {
                for (int k = j + 1; k < array.length; k++) {
                    if (array[j][i] == array[k][i]) {
                        result = true;
                    }
                }
            }
            if (result) {
                break;
            }
        }
        return result;
    }

    public boolean hasColumnWithMinimums(int[][] array, int numberOfMins) {
        boolean result = false;
        int count = 0;
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                list.add(array[i][j]);
            }
        }
        Collections.sort(list);
        LinkedHashSet<Integer> set = new LinkedHashSet<>();
        while (set.size() < numberOfMins) {
            set.add(list.get(count++));
        }
        for (int i = 0; i < array[0].length; i++) {
            count = 0;
            for (int j = 0; j < array.length; j++) {
                int u = array[j][i];
                if (set.contains(array[j][i])) {
                    count++;
                }
            }
            result = count >= 3;
            if (result) {
                break;
            }
        }
        return result;
    }
}
