package ru.job4j.homeworks.tasks;

//11.12.* Заполнить массив:
//        а) двадцатью первыми натуральными числами, делящимися нацело
//        на 13 или на 17 и находящимися в интервале, левая граница которого равна 300;
//        б) тридцатью первыми простыми числами (простым называется натураль-ное число,
//        большее 1, не имеющее других делителей, кроме единицы и са-мого себя).

public class Task1112 {
    public int[] numberTakeAway(int bound, int arraySize, int firstDivider, int secondDivider) {
//        bound = 300;
//        arraySize = 20;
//        firstDivider = 13;
//        secondDivider = 17;
//        для создания более универсальной программы все условия выведены в разряд переменных
        int[] result = new int[arraySize];
        for (int i = 0; i < result.length; i++) {
            while (bound % firstDivider != 0 && bound % secondDivider != 0) {
                bound++;
            }
            result[i] = bound;
            bound++;
        }
        return result;
    }

    public int[] naturalNumbersArray(int bound, int arraySize) {
        int[] result = new int[arraySize];
//        bound = 2;
//        arraySize = 30;
//        для создания более универсальной программы все условия выведены в разряд переменных
        for (int i = 0; i < result.length; i++) {
            boolean isSimple = false;
            while (!isSimple) {
                isSimple = true;
                for (int j = 2; j <= bound / 2; j++) {
                    if (bound % j == 0) {
                        isSimple = false;
                        break;
                    }
                }
                if (isSimple) {
                    result[i] = bound;
                }
                bound++;
            }
        }
        return result;
    }
}
