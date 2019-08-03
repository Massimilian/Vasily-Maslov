package ru.job4j.pool;

import ru.job4j.producerconsumer.SimpleBlockingQueue;

import java.util.LinkedList;
import java.util.List;

public class ThreadPoolSecond {
    private final List<Thread> threads = new LinkedList<>();
    private final SimpleBlockingQueue<Runnable> tasks = new SimpleBlockingQueue<>();
    private int size = Runtime.getRuntime().availableProcessors();

    public void work(Runnable job) {
        tasks.offer(job);
        clean();
        for (int i = 0; i < this.size - threads.size(); i++) {
            threads.add(new Thread(tasks.poll()));
        }
    }

    public void shutdown() {
        threads.forEach(Thread::interrupt);
    }

    private void clean() {
        for (int i = 0; i < threads.size(); i++) {
            if (!threads.get(i).isAlive()) {
                threads.remove(i);
            }
        }
    }
}
