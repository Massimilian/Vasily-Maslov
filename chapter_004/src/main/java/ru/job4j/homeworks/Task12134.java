package ru.job4j.homeworks;

//12.134. В двумерном массиве имеются только два одинаковых элемента. Найти их.

import java.util.ArrayList;
import java.util.List;

public class Task12134 {
    public int findTwins(int[][] array) {
        List<Integer> numbers = new ArrayList<>();
        for (int[] stringArray : array) {
            for (int number : stringArray) {
                numbers.add(number);
            }
        }
        boolean isFin = false;
        int result = 0;
        for (int i = 0; i < numbers.size() - 1; i++) {
            if (isFin) {
                break;
            }
            result = numbers.get(i);
            for (int j = i + 1; j < numbers.size(); j++) {
                if (result == numbers.get(j)) {
                    isFin = true;
                    break;
                }
            }
        }
        return result;
    }
}
