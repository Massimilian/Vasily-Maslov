package ru.job4j.homeworks;

//12.56. Дан двумерный массив. Определить:
//        а) сумму всех элементов массива;
//        б) сумму квадратов всех элементов массива;
//        в) среднее арифметическое всех элементов массива.

public class Task1256 {
    public int sum(int[][] array) {
        int result = 0;
        for (int[] arr : array) {
            for (int i : arr) {
                result += i;
            }
        }
        return result;
    }

    public int pow(int[][] array) {
        int result = 0;
        for (int[] arr : array) {
            for (int i : arr) {
                result += Math.pow(i, 2);
            }
        }
        return result;
    }

    public double middle(int[][] array) {
        double result = this.sum(array);
        int count = 0;
        for (int[] l : array) {
            count += l.length;
        }
        return result / count;
    }
}
