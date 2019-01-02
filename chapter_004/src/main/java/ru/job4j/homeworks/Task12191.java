package ru.job4j.homeworks;

//12.191.*В квадратном массиве выделим четыре четверти, ограниченные главной
//        и побочной диагоналями (без учета элементов, расположенных на диагоналях):
//        верхнюю, нижнюю, левую и правую. Поменять местами элементы:
//        а) верхней и нижней четвертей;
//        б) правой и левой четвертей;
//        в) левой и верхней четвертей;
//        г) правой и нижней четвертей;
//        д) верхней и правой четвертей;
//        е) левой и нижней четвертей.

public class Task12191 {
    public int[][] turnArray(int[][] array, int change) {
        int count;
        switch (change) {
            case 1:

                count = 1;
                for (int i = 0; i < array.length / 2; i++) {
                    for (int j = count; j < array.length - count; j++) {
                        array[i][j] = array[i][j] + array[array.length - 1 - i][j];
                        array[array.length - 1 - i][j] = array[i][j] - array[array.length - 1 - i][j];
                        array[i][j] = array[i][j] - array[array.length - 1 - i][j];
                    }
                    count++;
                }
                break;
            case 2:

                count = array.length / 2;
                for (int i = 1; i < count; i++) {
                    for (int j = 0; j < i; j++) {
                        array[i][j] = array[i][j] + array[i][array.length - 1 - j];
                        array[i][array.length - 1 - j] = array[i][j] - array[i][array.length - 1 - j];
                        array[i][j] = array[i][j] - array[i][array.length - 1 - j];
                        array[array.length - 1 - i][j] = array[array.length - 1 - i][j] + array[array.length - 1 - i][array.length - 1 - j];
                        array[array.length - 1 - i][array.length - 1 - j] = array[array.length - 1 - i][j] - array[array.length - 1 - i][array.length - 1 - j];
                        array[array.length - 1 - i][j] = array[array.length - 1 - i][j] - array[array.length - 1 - i][array.length - 1 - j];
                    }
                    if (array.length % 2 != 0) {
                        for (int j = 0; j < array.length / 2; j++) {
                            array[array.length / 2][j] = array[array.length / 2][j] + array[array.length / 2][array.length - 1 - j];
                            array[array.length / 2][array.length - 1 - j] = array[array.length / 2][j] - array[array.length / 2][array.length - 1 - j];
                            array[array.length / 2][j] = array[array.length / 2][j] - array[array.length / 2][array.length - 1 - j];
                        }
                    }
                }
                break;

            case 3:
                count = array.length % 2 == 0 ? array.length / 2 - 1 : array.length / 2;
                for (int i = 0; i < count; i++) {
                    for (int j = 1 + i; j < array.length - 1 - i; j++) {
                        array[i][j] = array[i][j] + array[j][i];
                        array[j][i] = array[i][j] - array[j][i];
                        array[i][j] = array[i][j] - array[j][i];
                    }
                }
                break;

            case 4:
                count = array.length / 2;
                for (int i = array.length - 1; i > count; i--) {
                    for (int j = array.length - i; j < i; j++) {
                        array[i][j] = array[i][j] + array[j][i];
                        array[j][i] = array[i][j] - array[j][i];
                        array[i][j] = array[i][j] - array[j][i];
                    }
                }
                break;

            case 5:
                count = array.length % 2 == 0 ? array.length / 2 - 1 : array.length / 2;
                for (int i = 0; i < count; i++) {
                    for (int j = i + 1; j < array.length - 1 - i; j++) {
                        array[i][j] = array[i][j] + array[array.length - 1 - j][array.length - 1 - i];
                        array[array.length - 1 - j][array.length - 1 - i] = array[i][j] - array[array.length - 1 - j][array.length - 1 - i];
                        array[i][j] = array[i][j] - array[array.length - 1 - j][array.length - 1 - i];
                    }
                }
                break;

            case 6:
                for (int i = array.length - 1; i > array.length / 2; i--) {
                    for (int j = array.length - i; j < i; j++) {
                        array[i][j] = array[i][j] + array[array.length - 1 - j][array.length - 1 - i];
                        array[array.length - 1 - j][array.length - 1 - i] = array[i][j] - array[array.length - 1 - j][array.length - 1 - i];
                        array[i][j] = array[i][j] - array[array.length - 1 - j][array.length - 1 - i];
                    }
                }
                break;
            default:
                System.out.println("Unknown operation");
        }
        return array;
    }
}
