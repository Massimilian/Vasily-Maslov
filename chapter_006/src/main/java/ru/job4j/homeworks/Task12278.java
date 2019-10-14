package ru.job4j.homeworks;

//12.278. Найти количество строк массива, в которых имеется ровно три буквы о.

public class Task12278 {
    public int find(char[][] chars, char toFind, int number) {
        int result = 0;
        int count;
        for (int i = 0; i < chars.length; i++) {
            count = 0;
            for (int j = 0; j < chars[i].length; j++) {
                if (chars[i][j] == toFind) {
                    count++;
                }
            }
            result = count == number ? result + 1 : result;
        }
        return result;
    }
}
