package ru.job4j.threads.threadsproblems.racecondition;

public class RaceClass implements Runnable {

    Counter counter;
    boolean info;

    public RaceClass(Counter counter, boolean info) {
        this.counter = counter;
        this.info = info;
    }

    @Override
    public void run() {
        // создадим временную "дистанцию" для "забега"
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
//        Закомментированный код - вариант борьбы с проблемой путём создания "флага"
//        if (!counter.wasChanged) {
        counter.setInfo(info);
//        }
    }
}
