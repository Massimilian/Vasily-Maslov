 package ru.job4j.homeworks.coffeemachine;

public class CoffeeMachine {
     int[] changes(int value, int price) {
        int change = value > price ? value - price : 0;
        int[] result = new int[change];
        int[] values = {10, 5, 2, 1};
        int count = 0;
        for (int i = 0; i < values.length; i++) {
            while (change >= values[i]) {
                change = change - values[i];
                result[count] = values[i];
                count++;
            }
        }
        int[] finalResult = new int[count];
        for (int i = 0; i < count; i++) {
            finalResult[i] = result[i];
        }
        return finalResult;
    }
}