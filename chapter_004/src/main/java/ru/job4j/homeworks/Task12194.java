package ru.job4j.homeworks;

//12.194. Дан двумерный массив.
//        а) Заменить значения всех элементов второй строки массива числом 5.
//        б) Заменить значения всех элементов пятого столбца массива числом 10.

public class Task12194 {
    public int[][] changeColumnOrString(int[][] array, int position, int count, boolean isColumn) {
        if (isColumn) {
            for (int i = 0; i < array.length; i++) {
                try {
                    array[i][position] = count;
                } catch (ArrayIndexOutOfBoundsException aioobe) {
                    continue;
                }
            }
        } else {
            for (int i = 0; i < array[position].length; i++) {
                array[position][i] = count;
            }
        }
        return array;
    }
}
