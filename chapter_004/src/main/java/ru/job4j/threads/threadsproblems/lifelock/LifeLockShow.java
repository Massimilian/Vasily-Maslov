package ru.job4j.threads.threadsproblems.lifelock;

public class LifeLockShow {
    public static void main(String[] args) {
//      Создаём два объекта класса PoliteMan
        PoliteMan man1 = new PoliteMan("First", true);
        PoliteMan man2 = new PoliteMan("Second", true);

//      Создаём класс BackPoliteMan, который будет содержать в себе первый объект (потом будут перемены);
        BackPoliteMan someMan = new BackPoliteMan(man1);

//      при помощи двух анонимных классов создаём два потока.
        new Thread(new Runnable() {
            @Override
            public void run() {
                man1.work(someMan, man2);
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                man2.work(someMan, man1);
            }
        }).start();
    }
}
