package ru.job4j.homeworks.ExamTask;

public class WorkingPlace {
    public static void main(String[] args) {
        GarantedDeadLock first = new GarantedDeadLock("First");
        GarantedDeadLock second = new GarantedDeadLock("Second");

        new Thread(new Runnable() {
            @Override
            public void run() {
                first.start(second);
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                second.start(first);
            }
        }).start();
    }
}
