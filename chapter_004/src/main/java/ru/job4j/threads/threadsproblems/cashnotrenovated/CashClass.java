package ru.job4j.threads.threadsproblems.cashnotrenovated;

public class CashClass implements Runnable {
    Incrementator incr;
    int count;
    boolean iWas;

    public CashClass(Incrementator incr, int count, boolean iWas) {
        this.incr = incr;
        this.count = count;
        this.iWas = iWas;
    }

    public void change() {
        for (int i = 0; i < 500; i++) {
            incr.increment(count, iWas);
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void run() {
        change();
    }
}
