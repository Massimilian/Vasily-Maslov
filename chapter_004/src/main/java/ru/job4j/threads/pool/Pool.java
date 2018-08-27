package ru.job4j.threads.pool;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

public class Pool<T> {
    private final List<Thread> threads = new LinkedList<>();
    private final Queue<Runnable> tasks = new LinkedBlockingQueue<>();
    private final int size = Runtime.getRuntime().availableProcessors();

    // метод, запускающий выполнение задач в threads, определённых в очереди tasks
    public void run() {
        boolean on = true;
        // пока очередь на выполнение пуста, или  количество добавленныз нитей больше, чем переменная size
        while (tasks.isEmpty() || threads.size() > this.size) {
            try {
                // ставим переключатель на положение "не on"
                on = false;
                //ждём
                tasks.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        if (!on) {
            // если очередь ожидает, пробуждаем её, переключая выключатель: пришла новая задача,
            tasks.notify();
        }
        if (threads.size() > this.size) {
            // добавляем в threads новый поток, который параметром принимает Runnable из tasks
            // (который, в свою очередь, удаляется из tasks),
            threads.add(new Thread(tasks.poll()));
            // иначе
        }
    }

    // добавляем новый объект Runnable в tasks
    public void work(Runnable job) {
        tasks.add(job);
    }

    public void shutdown() {

    }
}
