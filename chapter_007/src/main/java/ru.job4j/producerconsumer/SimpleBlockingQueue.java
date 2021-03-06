package ru.job4j.producerconsumer;

import net.jcip.annotations.GuardedBy;
import net.jcip.annotations.ThreadSafe;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Realisation of Producer-Consumer algorithm
 *
 * @param <T> is anyone
 */
@ThreadSafe
public class SimpleBlockingQueue<T> {

    @GuardedBy("this")
    private final Queue<T> queue = new LinkedList<>();

    public void offer(T value) {
        synchronized (this) {
            int maxSize = 10;
            while (queue.size() >= maxSize) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            this.queue.offer(value);
            notifyAll();
        }
    }

    public T poll() {
        synchronized (this) {
            while (queue.isEmpty()) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            T t = this.queue.poll();
            notifyAll();
            return t;
        }
    }

    public boolean isEmpty() {
        return this.queue.isEmpty();
    }
}
