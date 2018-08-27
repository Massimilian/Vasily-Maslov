package ru.job4j.threads.pool;

import org.junit.Test;

import java.util.concurrent.TimeUnit;

public class PoolTest {
    private Pool pool = new Pool();
    private Runnable r = () -> {};

    @Test
    public void whenTryToWorkThenDoIt() {
        for (int i = 0; i < 5; i++) {
            pool.work(r);
        }
        pool.run();
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
