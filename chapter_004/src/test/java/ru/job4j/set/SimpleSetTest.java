package ru.job4j.set;

import org.junit.Test;

import java.util.Iterator;
import java.util.Random;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class SimpleSetTest {
    private SimpleSet<Boolean> ss = new SimpleSet<>();

    @Test
    public void whenAddTwoPointsIntoSetThenReturnThem() {
        ss.add(true);
        ss.add(false);
        assertThat(ss.get(0), is(true));
        assertThat(ss.get(1), is(false));
    }

    @Test
    public void whenAddThreeEqualsIntoSetThenReturnOnlyNotEquals() {
        Random random = new Random();
        ss.add(random.nextBoolean());
        ss.add(random.nextBoolean());
        ss.add(random.nextBoolean());
        Iterator<Boolean> iterator = ss.iterator();
        assertThat(iterator.hasNext(), is(true));
        iterator.next();
        iterator.next();
        assertThat(iterator.hasNext(), is(false));
    }
}
