package ru.job4j.homeworks.simpletasks;

// Реализовать класс вычисляющий простые числа до N.

import java.util.LinkedList;

public class Task8 {
    public LinkedList<Integer> simpleNumbers(int number) {
        LinkedList<Integer> result = new LinkedList<>();
        for (int i = 2; i < number; i++) {
            int count = 0;
            for (int j = 2; j <= i / 2; j++) {
                if (i % j == 0) {
                    count++;
                }
            }
            if (count == 0) {
                result.add(i);
            }
        }
        return result;
    }
}
