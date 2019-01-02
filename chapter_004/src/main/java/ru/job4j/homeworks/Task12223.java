package ru.job4j.homeworks;

//12.223. Дан двумерный массив из четного числа столбцов. Поменять местами его
//        столбцы следующим способом: первый столбец поменять с последним,
//        второй — с предпоследним и т. д.

public class Task12223 {
    public int[][] mirrorChange(int[][] array) {
        int[][] result = new int[array.length][];
        for (int i = 0; i < array.length; i++) {
            result[result.length - 1 - i] = new int[array[i].length];
            for (int j = 0; j < array[i].length; j++) {
                result[result.length - 1 - i][j] = array[i][j];
            }
        }
        return result;
    }
}
