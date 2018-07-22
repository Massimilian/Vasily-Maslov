package ru.job4j.threads.threadsproblems.racecondition;

public class RaceConditionsShow {
    public static void main(String[] args) {
        // Создаём некий класс Counter, который содержитв себе булеву переменную (просто чтобы проще было работать)
        Counter counter = new Counter();
        // Создаём два потока, каждый из которых планирует установить своё значение в булеву переменную.
        Thread thread1 = new Thread(new RaceClass(counter, false));
        Thread thread2 = new Thread(new RaceClass(counter, true));
        // Кто из них добежит последним и установит своё значение - загадка.
        thread1.start();
        thread2.start();
        try {
            // даём тайм-аут главному потоку, чтобы в гонках не участвовало уже три потока
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(counter.hasInfo);
    }
}
