package ru.job4j.homeworks;

//12.157. Вывести на экран (в одну строку):
//        а) все элементы побочной диагонали квадратного массива,
//        начиная с элемента, расположенного в правом верхнем углу;
//        б) все элементы главной диагонали квадратного массива,
//        начиная с элемента, расположенного в правом нижнем углу.

public class Task12157 {
    public int[] leftDiagonal(int[][] array) {
        int[] result = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            result[i] = array[i][i];
        }
        return result;
    }

    public int[] rightResult(int[][] array) {
        int[] result = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            result[i] = array[i][array.length - 1 - i];
        }
        return result;
    }
}
