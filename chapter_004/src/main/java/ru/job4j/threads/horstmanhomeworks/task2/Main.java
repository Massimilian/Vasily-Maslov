package ru.job4j.threads.horstmanhomeworks.task2;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {
        Random random = new Random();
        ExecutorService ex = Executors.newSingleThreadExecutor();
        for (int i = 0; i < 10; i++) {
            ex.execute(new Fib(random.nextInt(100), Integer.toString(i) + " thread: "));
        }
        ex.shutdown();
    }
}
