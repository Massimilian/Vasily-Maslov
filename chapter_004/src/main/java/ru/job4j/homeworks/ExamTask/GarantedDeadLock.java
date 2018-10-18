package ru.job4j.homeworks.ExamTask;

import java.util.concurrent.TimeUnit;

public class GarantedDeadLock {
    String name;

    public GarantedDeadLock(String name) {
        this.name = name;
    }

    public synchronized void start(GarantedDeadLock gdl) {
        System.out.printf("%s working.%s", gdl.name, System.lineSeparator());
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println();
        gdl.cont(this);
    }

    public synchronized void cont(GarantedDeadLock gdl) {
        System.out.printf("Why %s is not locked???%s", gdl.name, System.lineSeparator());
    }
}
