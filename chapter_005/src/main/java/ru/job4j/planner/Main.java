package ru.job4j.planner;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Task task1 = new Task("Information - 1", 1);
        Task task2 = new Task("Information - 2", 2);
        Task task3 = new Task("Information - 3", 3);
        Task task4 = new Task("Information - 4", 4);
        TaskStorage.getInstance().add(task1);
        TaskStorage.getInstance().add(task2);
        TaskStorage.getInstance().add(task3);
        TaskStorage.getInstance().add(task4);
    }
}
