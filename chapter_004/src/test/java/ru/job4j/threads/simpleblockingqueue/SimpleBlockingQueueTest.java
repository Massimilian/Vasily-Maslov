package ru.job4j.threads.simpleblockingqueue;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class SimpleBlockingQueueTest {
    private final SimpleBlockingQueue<Integer> sbq = new SimpleBlockingQueue();

    @Test
    public void whenTryToUseSimpleQueueThenItWorksWellAndSyncronized() {
        Thread one = new Thread() {
            @Override
            public void run() {
                sbq.poll();
                sbq.poll();
            }
        };

        Thread two = new Thread() {
            @Override
            public void run() {
                sbq.offer(1);
                sbq.offer(2);
                sbq.offer(3);
                sbq.offer(4);
                sbq.offer(0);
            }
        };

        Thread three = new Thread() {
            @Override
            public void run() {
                sbq.poll();
                sbq.poll();
            }
        };

        one.start();
        two.start();
        three.start();

        try {
            one.join();
            two.join();
            three.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        assertThat(sbq.size(), is(1));
    }
}
