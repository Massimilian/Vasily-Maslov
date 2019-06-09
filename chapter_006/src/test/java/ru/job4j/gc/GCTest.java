package ru.job4j.gc;

import org.junit.Test;

import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class GCTest {
    private Softs s = new Softs();
    private String ask = "test";
    private String info = "I think, and that is why I'm clever.";
    private String wrongAsk = "test-two";

    @Test
    public void whenTryToPutIntoSoftsValueThenDoIt() {
        s.getSoft(this.ask);
        assertThat(s.getMap().get(this.ask).get(), is(this.info));
        assertThat(s.getSoft(this.ask).get(), is(this.info));
        s.getSoft(this.wrongAsk);
        assertThat(s.getMap().containsKey(this.wrongAsk), is(false));
    }
}
