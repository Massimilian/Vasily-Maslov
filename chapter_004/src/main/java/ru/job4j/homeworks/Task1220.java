package ru.job4j.homeworks;

//12.20. Дан двумерный массив целых чисел. Выяснить:
//        а) имеются ли четные числа в левом верхнем или в левом нижнем углу;
//        б) имеются ли числа, оканчивающиеся нулем, в правом верхнем или в правом нижнем углу.

public class Task1220 {
    public boolean hasEven(int[][] doubleArray) {
        return doubleArray[0][0] % 2 == 0 && doubleArray[doubleArray.length - 1][0] % 2 == 0;
    }

    public boolean hasNulls(int[][] doubleArray) {
        int i = doubleArray[0].length - 1;
        int u = doubleArray[doubleArray.length - 1][doubleArray[doubleArray.length - 1].length - 1];
        return doubleArray[0][doubleArray[0].length - 1] % 10 == 0 && doubleArray[doubleArray.length - 1][doubleArray[doubleArray.length - 1].length - 1] % 10 == 0;
    }
}