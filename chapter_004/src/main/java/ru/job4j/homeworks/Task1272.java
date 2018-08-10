package ru.job4j.homeworks;

//12.72. Дан двумерный массив целых чисел. Определить:
//        а) сумму четных элементов массива;
//        б) количество элементов массива, меньших n;
//        в) среднее арифметическое нечетных элементов массива;
//        г) сумму тех элементов массива, сумма индексов которых кратна трем.

public class Task1272 {
    public int sumOfEven(int[][] array) {
        int result = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                result = array[i][j] % 2 == 0 ? result + array[i][j] : result;
            }
        }
        return result;
    }

    public int smallerThen(int[][] array, int count) {
        int result = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                result = array[i][j] < count ? result + 1 : result;
            }
        }
        return result;
    }


    public double middleOfNotEven(int[][] array) {
        int result = 0;
        int number = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                number = array[i][j] % 2 != 0 ? number + 1 : number;
                result = array[i][j] % 2 != 0 ? result + array[i][j] : result;
            }
        }
        return result / number;
    }

    public int sumOfEveryThird(int[][] array) {
        int count = 0;
        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                if (count % 3 != 0) {
                    count++;
                } else {
                    count = 1;
                    sum += array[i][j];
                }
            }
        }
        return sum;
    }
}