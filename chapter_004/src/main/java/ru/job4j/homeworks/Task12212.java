package ru.job4j.homeworks;

//12.212. В каждом столбце двумерного массива поменять местами первый отрицательный элемент и последний нулевой.
//        Если таких элементов нет, то должно быть выведено соответствующее сообщение.

public class Task12212 {
    public int[][] changeSubzeroAndZero(int[][] array) {
        int posZero = 0;
        int posSubzero = 0;
        boolean wasNoChanges = true;
        boolean hasZero;
        boolean hasSubzero;
        for (int i = 0; i < array.length; i++) {
            hasZero = false;
            hasSubzero = false;
            for (int j = 0; j < array[i].length; j++) {
                if (!hasSubzero && array[i][j] < 0) {
                    hasSubzero = true;
                    posSubzero = j;
                }
                if (array[i][j] == 0) {
                    hasZero = true;
                    posZero = j;
                }
            }
            if (hasSubzero && hasZero) {
                wasNoChanges = false;
                array[i][posZero] += array[i][posSubzero];
                array[i][posSubzero] = array[i][posZero] - array[i][posSubzero];
                array[i][posZero] -= array[i][posSubzero];
            }
        }
        if (wasNoChanges) {
            System.out.println("There was no any changes!");
        }
        return array;
    }
}
