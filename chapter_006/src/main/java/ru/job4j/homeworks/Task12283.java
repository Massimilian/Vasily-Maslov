package ru.job4j.homeworks;

//12.283. Найти:
//        а) номер первого по порядку столбца массива, содержащего наибольшее
//        число пробелов;
//        б) номер последней по порядку строки массива, содержащей наибольшее
//        количество букв ш и щ;
//        в)* номер первой по порядку строки массива, содержащей наибольшее чис-
//        ло цифр.

public class Task12283 {
    public int maxCol(char[][] array) {
        int result = 0;
        int max = 0;
        int count;
        for (int i = 0; i < array[0].length; i++) {
            count = 0;
            for (int j = 0; j < array.length; j++) {
                if (array[j][i] == ' ') {
                    count++;
                }
            }
            result = count > max ? i : result;
            max = count > max ? count : max;
        }
        return result;
    }

    public int lastMaxSymb(char[][] array, char[] symbols, boolean theLast) {
        int result = 0;
        int max = 0;
        int count;
        for (int i = 0; i < array.length; i++) {
            count = 0;
            for (int j = 0; j < array[i].length; j++) {
                for (int k = 0; k < symbols.length; k++) {
                    if (symbols[k] == array[i][j]) {
                        count++;
                        break;
                    }
                }
            }
            if (theLast) {
                result = max <= count ? i : result;
            } else {
                result = max < count ? i : result;
            }
            max = max < count ? count : max;
        }
        return result;
    }

    public int findNums(char[][] array) {
        char[] numbers = new char[10];
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = (char) (i + 48);
        }
        return lastMaxSymb(array, numbers, false);
    }
}
