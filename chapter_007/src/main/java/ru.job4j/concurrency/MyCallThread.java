package ru.job4j.concurrency;

import java.util.concurrent.Callable;

public class MyCallThread implements Callable<String> {
    @Override
    public String call() throws Exception {
        return "ANOTHER SURPRISE!";
    }
}
