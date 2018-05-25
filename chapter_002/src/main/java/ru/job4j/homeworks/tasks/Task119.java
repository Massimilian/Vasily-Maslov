package ru.job4j.homeworks.tasks;

//11.9. Заполнить массив:
//        а) десятью первыми членами арифметической прогрессии с известным пер-вым членом прогрессии а и ее разностью р;
//        б) двадцатью первыми членами геометрической прогрессии с известным первым членом прогрессии а и ее знаменателем z;
//        в) двенадцатью первыми членами последовательности Фибоначчи (после-довательности, в которой первые два члена равны 1,
//        а каждый следующий равен сумме двух предыдущих).

public class Task119 {
    public int[] arithmeticProgress(int first, int step) {
        int[] result = new int[10];
        result[0] = first;
        for (int i = 1; i < result.length; i++) {
            result[i] = result[i - 1] + step;
        }
        return result;
    }

    public int[] geometricProgress(int first, int step) {
        int[] result = new int[20];
        result[0] = first;
        for (int i = 1; i < result.length; i++) {
            result[i] = result[i - 1] * step;
        }
        return result;
    }

    public int[] easyFibonachiPrigress() {
        return new int[]{1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144};
    }

    public int[] fibonachiProgress() {
        int[] fib = new int[12];
        //fib[0] = fib[1] = 1; inner assigment should be avoid
        fib[0] = 1;
        fib[1] = fib[0];
        for (int i = 2; i < fib.length; i++) {
            fib[i] = fib[i - 2] + fib[i - 1];
        }
        return fib;
    }
}
