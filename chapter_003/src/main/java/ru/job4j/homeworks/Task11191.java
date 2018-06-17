package ru.job4j.homeworks;

//11.191.*Дано натуральное число n. Определить количество различных цифр в нем.
//        Например, в числе 1234 количество различных цифр равно 4, в числе
//        22424 — 2, в числе 333 — 1.

public class Task11191 {
    public int equalsNumbers(int u) {
        char[] ch = Integer.toString(u).toCharArray();
        int count = ch.length;
        for (int i = 0; i < ch.length - 1; i++) {
            if (ch[i] == '*') {
                continue;
            }
            for (int j = i + 1; j < ch.length; j++) {
                if (ch[i] == ch[j]) {
                    count--;
                    ch[j] = '*';
                }
            }
        }
        return count;
    }
}
