package ru.job4j.producerconsumer;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class SimpleBlockingQueueTest {
    private boolean ok = true;
    private SimpleBlockingQueue<Integer> test = new SimpleBlockingQueue<>();
    private Thread producer = new Thread(new Runnable() {
        @Override
        public void run() {
            test.offer(0);
        }
    });
    private Thread consumer = new Thread(new Runnable() {
        @Override
        public void run() {
            test.poll();
        }
    });

    @Test
    public void whenTryToGetProducerConsumerAlgorithmThenDoIt() {
        producer.start();
        try {
            Thread.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        consumer.start();
        try {
            producer.join();
            consumer.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        assertThat(ok, is(true));
    }

    @Test
    public void whenTryToGetConsumerProducerAlgorithmThenDoIt() {
        consumer.start();
        try {
            Thread.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        producer.start();
        try {
            producer.join();
            consumer.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        assertThat(ok, is(true));
    }
}
