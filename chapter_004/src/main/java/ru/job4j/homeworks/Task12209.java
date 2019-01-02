package ru.job4j.homeworks;

//12.209. Дан двумерный массив целых чисел.
//        а) Последний четный элемент каждого столбца уменьшить на 1 (предполагается, что в каждом столбце есть четный элемент).
//        б) Первый нулевой элемент каждой строки заменить числом –1 (предполагается, что в каждой строке есть нулевой элемент).

public class Task12209 {
    public int[][] decremChange(int[][] array) {
        int count;
        for (int i = 0; i < array.length; i++) {
            count = 0;
            for (int j = 0; j < array[i].length; j++) {
                count = array[i][j] % 2 == 0 && array[i][j] != 0 ? j : count;
            }
            array[i][count]--;
        }
        return array;
    }

    public int[][] zeroChange(int[][] array) {
        int count;
        for (int i = 0; i < array.length; i++) {
            count = 0;
            for (int j = 0; j < array[i].length; j++) {
                if (array[i][j] == 0) {
                    count = j;
                    break;
                }
            }
            array[i][count]--;
        }
        return array;
    }
}
