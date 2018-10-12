package ru.job4j.threads.pool;

import java.util.LinkedList;

// материал взят с https://www.ibm.com/developerworks/ru/library/j-jtp0730/

public class WorkQueue {
    // создаём предполагаемое количество потоков
    private final int nThreads = Runtime.getRuntime().availableProcessors();
    // создаём массив для хоанения потоков
    private final PoolWorker[] threads = new PoolWorker[nThreads];
    // сохздаём очередь для хранения нитей
    private final LinkedList<Runnable> queue = new LinkedList<Runnable>();

    public WorkQueue() {
        // заполняем массив экземплярами класса PoolWorker, которые сразу же и будем дёргать
        for (int i = 0; i < nThreads; i++) {
            threads[i] = new PoolWorker();
            threads[i].start();
        }
    }

    // метод для непосредственной работы пула
    public void execute(Runnable r) {
        synchronized (queue) {
            // добавляем Runnable
            queue.addLast(r);
            // дёргаем очередь
            queue.notify();
        }
    }

    // класс берёт из очереди queue поток и перемещает его в пул.
    private class PoolWorker extends Thread {
        public void run() {
            // создаём Runnable, в который можно засунуть конкретное действие
            Runnable r;
            while (true) {
                // проверяем вариант, когда очередь пуста
                synchronized (queue) {
                    while (queue.isEmpty()) {
                        try {
                            // даём команду ждать.
                            queue.wait();
                        } catch (InterruptedException ie) {
                            ie.printStackTrace();
                        }
                    }
                    // собственно, помещаем необходимое действие в Runnable (если очередь queue не пуста)
                    r = queue.removeFirst();
                }
                // Если в очереди есть потоки, то начинаем работать
                try {
                    r.run();
                } catch (RuntimeException re) {
                    re.printStackTrace();
                }
            }
        }
    }
}

