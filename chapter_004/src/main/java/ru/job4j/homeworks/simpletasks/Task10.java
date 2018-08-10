package ru.job4j.homeworks.simpletasks;

// Реализовать методы проверки корректности открытых и закрытых скобок. Например, ()(()((()))) - true, ()) - false

public class Task10 {
    public boolean allClosed(String str) {
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '(') {
                count++;
            }
            if (str.charAt(i) == ')') {
                count--;
            }
        }
        return count == 0;
    }
}
