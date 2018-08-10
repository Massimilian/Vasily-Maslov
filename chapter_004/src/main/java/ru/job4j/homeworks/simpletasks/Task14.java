package ru.job4j.homeworks.simpletasks;

// Задано предложение. Нужно переставить слова в обратно порядке.
// Например, "программируй и зарабатывай" -> "зарабатывай и программируй"

public class Task14 {
    public String removeWords(String string) {
        String result = "";
        String[] str = string.split(" ");
        for (int i = str.length - 1; i >= 0; i--) {
            result += " " + str[i];
        }
        result = result.trim();
        return result;
    }
}
