package ru.job4j.threads.horstmanhomeworks.task2;

public class Fib implements Runnable {
    int n;
    String name;

    public Fib(int n, String name) {
        this.n = n;
        this.name = name;
    }

    @Override
    public void run() {
        int oldResult = 1;
        int veryOldResult = 0;
        int result = oldResult + veryOldResult;
        while (result <= n) {
            System.out.println(name + ": " + result);
            veryOldResult = oldResult;
            oldResult = result;
            result = oldResult + veryOldResult;
        }
        Thread.yield();
    }
}
