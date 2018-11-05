package ru.job4j.homeworks.switcher;

import java.util.concurrent.TimeUnit;

public class SwitcherFirst {
    public static void main(String[] args) {
        StringObjectWorker sow = new StringObjectWorker("First", 10);
        StringObjectWorker sowTwo = new StringObjectWorker("Second", 10);
        while (true) {
            Thread t = new Thread(sow);
            Thread t2 = new Thread(sowTwo);
            t.start();
            try {
                t.join();
                TimeUnit.SECONDS.sleep(1); // для наглядного показа работы программы
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            t2.start();
            try {
                t2.join();
                for (int i = 0; i < 1; i *= i) {
                }
//                TimeUnit.SECONDS.sleep(1); // для наглядного показа работы программы
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}