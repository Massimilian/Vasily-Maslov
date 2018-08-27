package ru.job4j.homeworks;

//12.75. *Дан двумерный массив ненулевых целых чисел.
//        Определить, сколько раз элементы массива меняют знак
//        (принимая, что массив просматривается построчно сверху вниз,
//        а в каждой строке — слева направо).

public class Task1275 {
    public int howMuchChangeMinus(int[][] array) {
        int result = 0;
        int theFirst = 0;
        int theLast = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i].length != 0) {
                theFirst = array[i][0];
            }
            if (i != 0) {
                result = theLast < 0 && theFirst >= 0 || theLast >= 0 && theFirst < 0 ? result++ : result;
            }
            for (int j = 1; j < array[i].length; j++) {
                if (array[i][j] < 0 && theFirst >= 0 || array[i][j] >= 0 && theFirst < 0) {
                    result++;
                }
                theFirst = array[i][j];
            }
            theLast = theFirst;
        }
        return result;
    }
}
