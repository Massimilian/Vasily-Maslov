package ru.job4j.list;

import org.junit.Test;

import java.util.Iterator;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class DinamicLinkedContainerTest {
    private DinamicLinkedContainer<Integer> dlc = new DinamicLinkedContainer<>();

    @Test
    public void whenTryToAddNewPositionThenDoIt() {
      dlc.add(100);
      assertThat(dlc.get(0), is(100));
    }

    @Test
    public void whenTryToUseIteratorThenWorkWell() {
        dlc.add(100);
        dlc.add(200);
        dlc.add(300);
        dlc.add(400);
        Iterator<Integer> iterator = dlc.iterator();
        assertThat(iterator.next(), is(100));
        assertThat(iterator.next(), is(200));
        assertThat(iterator.hasNext(), is(true));
        assertThat(iterator.hasNext(), is(true));
        assertThat(iterator.next(), is(300));
        assertThat(iterator.next(), is(400));
        assertThat(iterator.hasNext(), is(false));
    }
}
