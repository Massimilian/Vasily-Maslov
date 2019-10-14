package ru.job4j.homeworks;

//12.273. Напечатать слова, образованные четными элементами каждой строки массива.

public class Task12273 {
    public String takeEven(char[][] array, boolean ev) {
        String result = new String();
        for (char[] anArray : array) {
            for (int j = ev ? 0 : 1; j < anArray.length; j += 2) {
                result += anArray[j];
            }
        }
        return result;
    }
}
