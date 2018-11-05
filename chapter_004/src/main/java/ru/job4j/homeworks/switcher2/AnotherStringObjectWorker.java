package ru.job4j.homeworks.switcher2;

import ru.job4j.homeworks.switcher.StringObject;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class AnotherStringObjectWorker implements Runnable {
    private StringObject so = new StringObject();
    private String name;
    private int count;
    private CountDownLatch latch;

    public AnotherStringObjectWorker(String name, int count, CountDownLatch cdl) {
        this.name = name;
        this.count = count;
        this.latch = cdl;
    }

    public AnotherStringObjectWorker(String name, int count) {
        this.name = name;
        this.count = count;
    }

    public void mainRun(int count) {
        System.out.printf("%s: %s %d%s.", this.name, so.getS(), count + 1, System.lineSeparator());
    }

    public void makeCountZero() {
        this.count = 0;
    }

    @Override
    public void run() {
        for (int i = 0; i < count; i++) {
            System.out.printf("%s: %s %d%s.", this.name, so.getS(), i + 1, System.lineSeparator());
            latch.countDown();
//            try {
//                TimeUnit.MILLISECONDS.sleep(500); // для наглядности работы программы
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
            for (int j = 0; j < 1; j *= j) {
            }
        }
    }
}