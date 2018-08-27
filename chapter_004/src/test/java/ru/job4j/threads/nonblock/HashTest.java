package ru.job4j.threads.nonblock;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class HashTest {
    private Hash hash = new Hash();
    private Base base1 = new Base(0, 0);
    private Base base2 = new Base(1, 0);

//    @Test
//    public void whenTryToUseThisHashThenReturnCorrectResults() {
//        hash.add(base1);
//        hash.add(base2);
//        Thread t1 = new Thread(new Runnable() {
//            @Override
//            public void run() {
//                hash.update(base1);
//                hash.delete(base2);
//            }
//        });
//        Thread t2 = new Thread(new Runnable() {
//            @Override
//            public void run() {
//                hash.update(base1);
//            }
//        });
//        t1.start();
//        t2.start();
//        try {
//            t1.join();
//            t2.join();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        assertThat(hash.getChm().size(), is(1));
//        assertThat(hash.getChm().containsKey(0), is(true));
//        assertThat(hash.getChm().get(0).getVersion(), is(2));
//    }
}
