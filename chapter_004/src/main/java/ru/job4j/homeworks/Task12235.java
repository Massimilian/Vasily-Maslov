package ru.job4j.homeworks;

//12.235. Дан двумерный массив.
//        а) Удалить из него первую из строк, сумма элементов которых не превышает некоторое заданное число.
//        б) Удалить из него первый из столбцов, количество нулей в котором равно некоторому заданному числу.

public class Task12235 {
    public int[][] deleteMinThen(int count, int[][] array) {
        int[][] result = new int[array.length][];
        int newCount;
        int point = 0;
        boolean isDone = false;
        for (int i = 0; i < array.length; i++) {
            newCount = 0;
            for (int j = 0; j < array[i].length; j++) {
                newCount += array[i][j];
            }
            if (newCount <= count || isDone) {
                result[point] = new int[array[i].length];
                for (int j = 0; j < array[i].length; j++) {
                    result[point][j] = array[i][j];
                }
                point++;
            } else {
                isDone = true;
            }
        }
        return result;
    }

    // Сделано с рассчётом на матрицу - ради упрощения
    public int[][] deleteWithZeroes(int count, int[][] array) {
        int[][] result;
        int newCount;
        int point = 0;
        boolean haveCorrectZeroes = false;
        boolean isDone = false;
        for (int i = 0; i < array[0].length; i++) {
            newCount = 0;
            for (int j = 0; j < array.length; j++) {
                if (array[j][i] == 0) {
                    newCount++;
                }
            }
            if (haveCorrectZeroes) {
                break;
            }
            if (newCount == count) {
                point = i;
                haveCorrectZeroes = true;
                break;
            }
        }
        if (!haveCorrectZeroes) {
            result = new int[array.length][array[0].length];
            for (int i = 0; i < array.length; i++) {
                for (int j = 0; j < array[i].length; j++) {
                    result[i][j] = array[i][j];
                }
            }
        } else {
            result = new int[array.length][array[0].length - 1];
            int corr;
            for (int i = 0; i < array.length; i++) {
                corr = 0;
                for (int j = 0; j < array[i].length; j++) {
                    if (j == point) {
                        corr++;
                        continue;
                    }
                    result[i][j - corr] = array[i][j];
                }
            }
        }
        return result;
    }
}
