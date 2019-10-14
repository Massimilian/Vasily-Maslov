package ru.job4j.concurrency;

public class MyThread implements Runnable {
    @Override
    public void run() {
        System.out.println("Run!"); //Стартует поток, все сдерживаемые ранее барьеры отпущены.
    }
}
