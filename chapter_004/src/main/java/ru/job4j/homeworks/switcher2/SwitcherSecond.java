package ru.job4j.homeworks.switcher2;


import java.util.concurrent.CountDownLatch;

public class SwitcherSecond {
    public static void main(String[] args) {
        int count = 10;
        AnotherStringObjectWorker asowSecond = new AnotherStringObjectWorker("Second", count);
        while (true) {
            CountDownLatch cdl = new CountDownLatch(count);
            AnotherStringObjectWorker asow = new AnotherStringObjectWorker("First", count, cdl);
            Thread t = new Thread(asow);
            t.start();
            try {
                cdl.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            for (int i = 0; i < count; i++) {
                asowSecond.mainRun(i);
            }
            asowSecond.makeCountZero();
        }
    }
}