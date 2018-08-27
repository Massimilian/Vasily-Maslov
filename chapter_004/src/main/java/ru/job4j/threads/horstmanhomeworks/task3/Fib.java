package ru.job4j.threads.horstmanhomeworks.task3;

import java.util.concurrent.Callable;

public class Fib implements Callable<Integer> {
    int i;

    public Fib(int i) {
        this.i = i;
    }

    @Override
    public Integer call() throws Exception {
        int counter = 0;
        int oldResult = 1;
        int veryOldResult = 0;
        int result = oldResult + veryOldResult;
        while (result <= this.i) {
            veryOldResult = oldResult;
            oldResult = result;
            result = oldResult + veryOldResult;
            counter++;
        }
        return counter;
    }
}
