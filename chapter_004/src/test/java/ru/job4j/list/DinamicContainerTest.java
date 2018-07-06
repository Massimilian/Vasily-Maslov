package ru.job4j.list;

import org.junit.Test;

import java.util.Iterator;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class DinamicContainerTest {
    private DinamicContainer<Integer> dc = new DinamicContainer<>();

    @Test
    public void whenTryToAddNewPointThenDoIt() {
        dc.add(100);
        assertThat(dc.get(0), is(100));
    }

    @Test
    public void whenTryToAddManyNewPointsThenDoIt() {
        for (int i = 0; i < 100; i++) {
            dc.add(i * 10);
        }
        assertThat(dc.get(9), is(90));
        assertThat(dc.get(19), is(190));
        assertThat(dc.get(99), is(990));
    }

    @Test
    public void whenTestDriveIteratorThenDoIt() {
        dc.add(100);
        dc.add(200);
        dc.add(300);
        Iterator<Integer> it = dc.iterator();
        assertThat(it.next(), is(100));
        assertThat(it.next(), is(200));
        assertThat(it.hasNext(), is(true));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(300));
        assertThat(it.hasNext(), is(false));
    }
}
