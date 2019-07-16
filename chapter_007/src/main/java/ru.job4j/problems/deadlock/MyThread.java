package ru.job4j.problems.deadlock;

public class MyThread implements Runnable {
    private Resourse res;

    public MyThread(Resourse res) {
        this.res = res;
    }

    @Override
    public void run() {
        res.get();
    }
}
