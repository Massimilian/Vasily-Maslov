package ru.job4j.problems.starvation;

public class MyThread implements Runnable {
    private Resourse res;
    private Baggage bag;
    private boolean isPoor;

    public MyThread(boolean isPoor, Resourse res, Baggage bag) {
        Thread.currentThread().setPriority(isPoor ? Thread.MIN_PRIORITY : Thread.MAX_PRIORITY);
        this.isPoor = isPoor;
        this.res = res;
        this.bag = bag;
    }

    @Override
    public void run() {
        while (res.getI() != 0) {
            res.dec();
            bag.incr();
            if (isPoor) {
                Thread.yield();
            }
        }
        System.out.printf("%s has finished.%s", Thread.currentThread().getName(), System.lineSeparator());
    }
}
