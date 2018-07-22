package ru.job4j.threads.threadsproblems.deadlock;

public class DeadLockShow {

    public static void main(String[] args) {
        Talking first = new Talking("First");
        Talking second = new Talking("Second");
//      Создаём два анонимных потока.
        new Thread(new Runnable() {
            @Override
            public void run() {
                first.tell(second);
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                second.tell(first);
            }
        }).start();
//        Оба метода стартовали, но при этом первый поток (со значением first) ждёт,
//        когда освободится замок со второго потока (со значением second), а второй метод ждёт того же от первого.
//        Возникает ситуация, когда мы не можем двинуться дальше. Забороть это можно, оборвав один из потоков
//        (тогда второй сможет проснуться и закончить своё дело).
//        Как это сделать в ситуации с анонимным классом - пока не понял.
        try {
            Thread.sleep(5000);
        } catch (InterruptedException ie) {
            ie.printStackTrace();
        }
        System.out.println("Are you sleeping?");
    }
}
