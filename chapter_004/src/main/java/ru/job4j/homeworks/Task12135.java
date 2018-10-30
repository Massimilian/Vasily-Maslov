package ru.job4j.homeworks;

//12.135. Дан двумерный массив целых чисел. В пятой строке имеются элементы,
//        равные 13. Определить номер столбца, в котором расположен самый левый
//        из таких элементов.

public class Task12135 {
    public int findColumn(int[][] array, int numOfString, int askedNumber) {
        int result = -1;
        for (int i = 0; i < array[numOfString].length; i++) {
            if (array[numOfString][i] == askedNumber) {
                result = i;
                break;
            }
        }
        return result;
    }
}
