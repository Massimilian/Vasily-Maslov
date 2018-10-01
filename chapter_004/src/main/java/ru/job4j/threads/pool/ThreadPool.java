package ru.job4j.threads.pool;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

public class ThreadPool<T> {
    private final List<Thread> threads = new LinkedList<>();
    private final Queue<Runnable> tasks = new LinkedBlockingQueue<>();
    private final int size = Runtime.getRuntime().availableProcessors();

    public void run() {
        boolean work = true;
        while (tasks.isEmpty() || threads.size() > this.size) {
            try {
                work = false;
                tasks.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        if (!work) {
            tasks.notify();
        }
        if (threads.size() > this.size) {
            threads.add(new Thread(tasks.poll()));
        }
    }

    public void work(Runnable job) {
        tasks.add(job);
    }

    public void shutdown() {

    }
}
