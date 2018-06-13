package ru.job4j.homeworks.tasks;

public class Test {
    public static void main(String[] args) {
        Task11165 test = new Task11165();
        int[] mountains = {0, 0};
        mountains = test.changed(mountains, -25, 25);
        for (int i: mountains) {
            System.out.print(i + " ");
        }
    }
}
