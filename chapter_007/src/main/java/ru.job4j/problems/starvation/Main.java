package ru.job4j.problems.starvation;

/**
 * Demonstrating starvation problem
 */
public class Main {
    public static void main(String[] args) {
        Resourse res = new Resourse(10000000);
        Baggage small = new Baggage(0);
        Baggage big = new Baggage(0);
        Thread s = new Thread(new MyThread(true, res, small));
        Thread b = new Thread(new MyThread(false, res, big));
        s.start();
        b.start();
        try {
            s.join();
            b.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(small.getI()); // small baggage will be always smaller.
        System.out.println(big.getI());
    }
}
