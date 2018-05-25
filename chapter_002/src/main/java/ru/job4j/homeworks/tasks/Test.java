package ru.job4j.homeworks.tasks;

public class Test {
    public static void main(String[] args) {
        Task1139 test = new Task1139();
        int[] numbers = new int[20];
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = i;
        }
        test.printArr(numbers, 8);
    }
}
