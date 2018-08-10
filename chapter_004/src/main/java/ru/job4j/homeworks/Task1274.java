package ru.job4j.homeworks;

//12.74. Дан двумерный массив. Найти число пар одинаковых соседних элементов. В качестве соседних рассматривать:
//        а) только элементы, расположенные в одной строке;
//        б) только элементы, расположенные в одном столбце;
//        в)* элементы, расположенные в одной строке и в одном столбце.

public class Task1274 {
    public int stringPares(int[][] array) {
        int count = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length - 1; j++) {
                if (array[i][j] == array[i][j + 1]) {
                    j++;
                    count++;
                }
            }
        }
        return count;
    }


    public int postPares(int[][] array) {
        int count = 0;
        for (int i = 1; i < array.length; i++) {
            for (int j = 0; j < array[i - 1].length && j < array[i].length; j++) {
                if (array[i][j] == array[i - 1][j]) {
                    count++;
                    if (i >= 2 && array[i - 2].length > j && array[i][j] == array[i - 2][j]) {
                        count = i >= 3 && array[i][j] == array[i - 3][j] ? count : count - 1;
                    }
                }
            }
        }
        return count;
    }

    public int allPares(int[][] array) {
        return this.postPares(array) + this.stringPares(array);
    }
}
