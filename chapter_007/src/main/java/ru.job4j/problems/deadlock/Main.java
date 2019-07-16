package ru.job4j.problems.deadlock;

import java.util.concurrent.TimeUnit;

/**
 * Demonstration DeadLock.
 */
public class Main {
    public static void main(String[] args) {
        Resourse one = new Resourse();
        Resourse two = new Resourse();
        one.setRes(two);
        two.setRes(one);
        new Thread(new MyThread(one)).start();
        new Thread(new MyThread(two)).start();
        new Thread(() -> {
            String w = "Still working...";
            while (true) {
                System.out.println(w);
                w += ".";
                try {
                    TimeUnit.SECONDS.sleep(3);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}
