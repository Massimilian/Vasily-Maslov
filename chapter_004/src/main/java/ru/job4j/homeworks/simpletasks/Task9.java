package ru.job4j.homeworks.simpletasks;

// Реализовать метод подсчета уникальных символов в строке.

import java.util.HashSet;
import java.util.Set;

public class Task9 {
    public int letters(String string) {
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < string.length(); i++) {
            set.add(string.charAt(i));
        }
        return set.size();
    }

    public int lettersWithoutEasyWays(String string) {
        int count = 0;
        char[] letters = new char[string.length()];
        for (int i = 0; i < string.length() - 1; i++) {
            boolean has = false;
            for (int j = 0; j < string.length(); j++) {
                if (letters[j] == string.charAt(i)) {
                    has = true;
                    break;
                }
                if (letters[j] == 0) {
                    break;
                }
            }
            if (!has) {
                letters[count++] = string.charAt(i);
            }
        }
        return count;
    }
}
