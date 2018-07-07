package ru.job4j.list;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class SimpleStackAndQueueTest {
    private SimpleStack<String> ss = new SimpleStack<>();
    private SimpleQueue<String> sq = new SimpleQueue<>();

    @Test
    public void whenAddNewPointsIntoStackAndTryToGetThemThenDoIt() {
        ss.push("first");
        ss.push("second");
        assertThat(ss.poll(), is("second"));
        assertThat(ss.poll(), is("first"));
    }

    @Test
    public void whenAddNewPointsIntoQueueAndTryToGetThemThenDoIt() {
        sq.push("first");
        sq.push("second");
        assertThat(sq.poll(), is("first"));
        assertThat(sq.poll(), is("second"));
    }

}
