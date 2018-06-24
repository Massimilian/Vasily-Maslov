package ru.job4j.doublearray;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class DoubleArrayIteratorTest {
    private DoubleArrayIterator dai = new DoubleArrayIterator(new int[][]{{1, 2}, {3, 4, 5}, {6, 7, 8, 9}});

    @Test
    public void whenAskThePointOfArrayThenReturnIt() {
        dai.next();
        dai.next();
        dai.next();
        assertThat(dai.next(), is(4));
    }

    @Test
    public void whenAskThePointOfArrayThenReturnItAnotherWay() {
        dai.next();
        dai.next();
        dai.next();
        dai.next();
        dai.next();
        dai.next();
        assertThat(dai.next(), is(7));
    }

    @Test
    public void whenAskThePointOfArrayThenReturnInfoAboutHasNextOrNo() {
        dai.next();
        dai.next();
        dai.next();
        dai.next();
        dai.next();
        dai.next();
        assertThat(dai.hasNext(), is(true));
    }

    @Test
    public void whenAskThePointOfArrayThenReturnInfoAboutHasNotNext() {
        dai.next();
        dai.next();
        dai.next();
        dai.next();
        dai.next();
        dai.next();
        dai.next();
        dai.next();
        dai.next();
        assertThat(dai.hasNext(), is(false));
    }
}
