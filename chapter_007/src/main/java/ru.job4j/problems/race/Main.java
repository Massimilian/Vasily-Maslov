package ru.job4j.problems.race;

/**
 * Demonstrating Race Condition
 */
public class Main {
    public static void main(String[] args) {
        Resourse r = new Resourse();
        MyThread one = new MyThread();
        MyThread two = new MyThread();
        one.setResourseAndName(r);
        two.setResourseAndName(r);
        one.start(); // one of them will be always the second.
        two.start();
    }
}
