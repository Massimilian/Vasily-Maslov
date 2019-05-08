package ru.job4j.gc;

import org.junit.Test;

import java.lang.ref.SoftReference;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class GCTest {
    private Softs s = new Softs();

    @Test
    public void whenTryToPutIntoSoftsValueThenDoIt() {
        s.put(1, "Testing value");
        s.put(2, 4264164);
        assertThat(((SoftReference<Object>) s.get(1)).get(), is("Testing value"));
        assertThat(((SoftReference<Object>) s.get(2)).get(), is(4264164));

    }
}
