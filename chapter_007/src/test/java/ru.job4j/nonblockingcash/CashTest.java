package ru.job4j.nonblockingcash;

import org.junit.Assert;
import org.junit.Test;

import java.util.concurrent.atomic.AtomicReference;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class CashTest {
    private Cash cash = new Cash();
    private Base a = new Base(1111);
    private Base b = new Base(2222);
    private Base c = new Base(3333);

    @Test
    public void whenTryToUseCashThenDoIt() {
        cash.add(a);
        cash.add(b);
        cash.add(c);
        cash.add(a);
        assertThat(cash.getStorage().size(), is(3));
        assertThat(cash.getStorage().get(a.getId()).getVersion(), is(1));
    }

    @Test
    public void whenThrowException() throws InterruptedException {
        AtomicReference<Exception> ex = new AtomicReference<>();
        Thread thread = new Thread(() -> {
            try {
                throw new OptimisticException();
            } catch (Exception e) {
                ex.set(e);
            }
        });
        thread.start();
        thread.join();
        Assert.assertThat(ex.get().getMessage(), is("Exception in optimization function."));
    }
}
