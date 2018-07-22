package ru.job4j.threads.threadsproblems.cashnotrenovated;

public class Incrementator {
    int count = 0;
    boolean whoRenovatesLast;

    public void increment(int i, boolean iWas) {
        this.count = count + i;
        this.whoRenovatesLast = iWas;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
