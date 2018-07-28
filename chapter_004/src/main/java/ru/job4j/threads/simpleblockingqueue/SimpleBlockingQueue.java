package ru.job4j.threads.simpleblockingqueue;

import net.jcip.annotations.GuardedBy;
import net.jcip.annotations.ThreadSafe;

import java.util.LinkedList;
import java.util.Queue;

@ThreadSafe
public class SimpleBlockingQueue<T> {

    @GuardedBy("this")
    // почему компилятор рекомендует сделать это поле final?
    final private Queue<T> queue = new LinkedList<>();

    public int size() {
        return queue.size();
    }

    public void offer(T value) {
        synchronized (queue) {
            queue.offer(value);
            queue.notify();
        }
    }

    public T poll() {
        synchronized (queue) {
            while (this.size() == 0) {
                try {
                    queue.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            return queue.poll();
        }
    }
}
