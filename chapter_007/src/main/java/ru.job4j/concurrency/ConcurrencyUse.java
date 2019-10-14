package ru.job4j.concurrency;

import java.util.Date;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;
import java.util.concurrent.ThreadLocalRandom;


public class ConcurrencyUse {
    public static void main(String[] args) {
        System.out.println(ThreadLocalRandom.current().nextInt()); // вывод случайного значения int
        System.out.println(ThreadLocalRandom.current().nextBoolean()); // вывод случайного значения boolean
    }
}