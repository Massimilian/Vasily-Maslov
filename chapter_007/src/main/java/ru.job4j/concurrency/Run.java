package ru.job4j.concurrency;

import java.util.concurrent.TimeUnit;

public class Run implements Runnable {
    @Override
    public void run() {
        System.out.printf("%s worked.%s", Thread.currentThread().getName(), System.lineSeparator());
    }
}
