package ru.job4j.set;

import org.junit.Test;

import java.util.Iterator;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class SimpleLinkedSetTest {
    private SimpleLinkedSet<Integer> sls = new SimpleLinkedSet<>();

    @Test
    public void whenAddPointIntoLinkedSetThenDoIt() {
        sls.add(0);
        sls.add(1);
        Iterator iterator = sls.iterator();
        assertThat(iterator.hasNext(), is(true));
        assertThat(iterator.next(), is(0));
        assertThat(iterator.hasNext(), is(true));
        assertThat(iterator.hasNext(), is(true));
        assertThat(iterator.next(), is(1));
        assertThat(iterator.hasNext(), is(false));
    }
}
