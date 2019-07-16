package ru.job4j.problems.deadlock;

import java.util.concurrent.TimeUnit;

public class Resourse {
    private Resourse res;

    public void setRes(Resourse res) {
        this.res = res;
    }

    public synchronized void get() {
        try {
            TimeUnit.MILLISECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        res.take();
    }

    private synchronized void take() {
        System.out.println("Resourse is working");
    }
}
