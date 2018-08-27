package ru.job4j.threads.horstmanhomeworks.task1;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {
        ExecutorService ex = Executors.newSingleThreadExecutor();
        for (int i = 0; i < 10; i++) {
            ex.execute(new Task1(Integer.toString(i)));
        }
        ex.shutdown();
    }
}
