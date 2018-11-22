package ru.job4j.homeworks;

//12.190.*В квадратном массиве выделим четыре четверти, ограниченные главной и
//        побочной диагоналями (без учета элементов, расположенных на диагоналях):
//        верхнюю, нижнюю, левую и правую. Найти сумму элементов:
//        а) верхней четверти; в) нижней четверти;
//        б) правой четверти; г) левой четверти.

//        1000001
//        0100010
//        0010100
//        0001000
//        0010100
//        0100010
//        1000001

//        100001
//        010010
//        001100
//        001100
//        010010
//        100001

public class Task12190 {
    public int sumOfQuarter(int[][] array, int pos) {
        int sum = 0;
        switch (pos) {
            case 1:
                for (int i = 0; i < array.length / 2; i++) {
                    for (int j = i + 1; j < array.length - i; j++) {
                        sum += array[i][j];
                    }
                }
                break;
            case 2:
                for (int i = 1; i < array.length - 1; i++) {
                    for (int j = i < array.length / 2 ? array.length - i : i + 1; j < array.length; j++) {
                        sum += array[i][j];
                    }
                }
                break;
            case 3:
                for (int i = array.length - 1; i > array.length / 2; i--) {
                    for (int j = array.length - i; j < i; j++) {
                        sum += array[i][j];
                    }
                }
                break;
            case 4:
                for (int i = 1; i < array.length / 2; i++) {
                    for (int j = 0; j < i; j++) {
                        sum += array[i][j];
                        sum += array[array.length - 1 - i][j];
                    }
                    if (array.length % 2 != 0) {
                        for (int j = 0; j < array.length / 2; j++) {
                            sum += array[array.length / 2][j];
                        }
                    }
                }
                break;
            default:
                System.out.println("Unknown operation");
                break;
        }
        return sum;
    }
}
