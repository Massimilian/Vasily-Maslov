package ru.job4j.homeworks;

//12.187.*Составить программу, которая определяет, является ли последовательность
//        элементов побочной диагонали квадратного массива упорядоченной
//        по невозрастанию (при просмотре от правого верхнего угла массива).
//        В случае отрицательного ответа должны быть напечатаны координаты
//        первого элемента, нарушающего указанную упорядоченность.

public class Task12187 {
    public int[] findNum(int[][] array) {
        int[] result = {-1, -1};
        int test = array[0][array[0].length - 1];
        for (int i = 1; i < array.length; i++) {
            if (test < array[i][array[i].length - 1 - i]) {
                result[0] = i;
                result[1] = array[i].length - 1 - i;
                break;
            } else {
                test = array[i][array[i].length - 1 - i];
            }
        }
        return result;
    }
}
