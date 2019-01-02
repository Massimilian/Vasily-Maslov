package ru.job4j.homeworks;

//12.241. Дан двумерный массив. Вставить в него:
//        а) строку из чисел 100 после строки с номером s;
//        б) столбец из нулей перед столбцом с номером k.

public class Task12241 {
    public int[][] modifyString(int[][] array, int pos, int num) {
        int[][] newArray = new int[array.length + 1][];
        boolean hasPassed = false;
        if (array.length < pos) {
            newArray = array;
            System.out.println("Uncorrect position of number!");
        } else {
            for (int i = 0; i < array.length; i++) {
                hasPassed = pos < i;
                if (!hasPassed) {
                    newArray[i] = new int[array[i].length];
                    for (int j = 0; j < array[i].length; j++) {
                        newArray[i][j] = array[i][j];
                    }
                } else {
                    newArray[i + 1] = new int[array[i].length];
                    for (int j = 0; j < array[i].length; j++) {
                        newArray[i + 1][j] = array[i][j];
                    }
                }
                if (pos == i) {
                    newArray[i + 1] = new int[array[i].length];
                    for (int j = 0; j < array[i].length; j++) {
                        newArray[i + 1][j] = num;
                    }
                }
            }
        }
        return newArray;
    }

    public int[][] modifyColumn(int[][] array, int pos, int num) {
        int[][] newArray = new int[array.length][];
        for (int i = 0; i < array.length; i++) {
            if (array[i].length < pos) {
                newArray = array;
                System.out.println("Uncorrect position of number!");
                break;
            }
            newArray[i] = new int[array[i].length + 1];
            for (int j = 0; j < array[i].length; j++) {
                if (j == pos) {
                    newArray[i][j] = num;
                    newArray[i][j + 1] = array[i][j];
                } else if (j > pos) {
                    newArray[i][j + 1] = array[i][j];
                } else {
                    newArray[i][j] = array[i][j];
                }
            }
        }
        return newArray;
    }
}
