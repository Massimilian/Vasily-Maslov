package ru.job4j.homeworks.tasks;

//11.60. Дан массив целых чисел. Выяснить:
//        а) верно ли, что сумма элементов, которые больше 20, превышает 100;
//        б) верно ли, что сумма элементов, которые меньше 50, есть четное число.

public class Task1160 {
    public boolean bigSum(int[] array) {
        boolean isBig = false;
        int sum = 0;
        for (int i : array) {
            if (i > 10) {
                sum += i;
            }
        }
        if (sum > 100) {
            isBig = true;
        }
        return isBig;
    }

    public boolean evenSum(int[] array) {
        boolean isEven = true;
        int sum = 0;
        for (int i : array) {
            if (i < 50) {
                sum += i;
            }
        }
        if (sum % 2 != 0) {
            isEven = false;
        }
        return isEven;
    }
}
