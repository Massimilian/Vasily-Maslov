package ru.job4j.differentarrays;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;


public class IteratorOfIteratorsTest {
    private Iterator<Integer> one = new ArrayIterator(new int[]{1, 2, 3});
    private Iterator<Integer> two = new DoubleArrayIterator(new int[][]{new int[]{4, 5}, new int[]{6, 7}});
    private Iterator<Integer> three = new EvenArrayIterator(new int[]{8, 9});

    private IteratorOfIterators ioi = new IteratorOfIterators(new Iterator[]{one, two, three});

    @Test
    public void whenTryToUseIteratorOfIteratorsThenReturnResult() {
        assertThat(ioi.hasNext(), is(true));
        assertThat(ioi.next(), is(1));
        assertThat(ioi.hasNext(), is(true));
        assertThat(ioi.next(), is(2));
        assertThat(ioi.hasNext(), is(true));
        assertThat(ioi.next(), is(3));
        assertThat(ioi.hasNext(), is(true));
        assertThat(ioi.next(), is(4));
        assertThat(ioi.hasNext(), is(true));
        assertThat(ioi.next(), is(5));
        assertThat(ioi.hasNext(), is(true));
        assertThat(ioi.next(), is(6));
        assertThat(ioi.hasNext(), is(true));
        assertThat(ioi.next(), is(7));
        assertThat(ioi.hasNext(), is(true));
        assertThat(ioi.next(), is(8));
        assertThat(ioi.hasNext(), is(false));
    }

    @Test
    public void testsThatNextMethodDoesntDependsOnPriorHasNextInvocation() {
        assertThat(ioi.next(), is(1));
        assertThat(ioi.next(), is(2));
        assertThat(ioi.next(), is(3));
        assertThat(ioi.next(), is(4));
        assertThat(ioi.next(), is(5));
        assertThat(ioi.next(), is(6));
        assertThat(ioi.next(), is(7));
        assertThat(ioi.next(), is(8));
    }

    @Test
    public void sequentialHasNextInvocationDoesntAffectRetrievalOrder() {
        assertThat(ioi.hasNext(), is(true));
        assertThat(ioi.hasNext(), is(true));
        assertThat(ioi.next(), is(1));
        assertThat(ioi.next(), is(2));
        assertThat(ioi.next(), is(3));
        assertThat(ioi.next(), is(4));
        assertThat(ioi.next(), is(5));
        assertThat(ioi.next(), is(6));
        assertThat(ioi.next(), is(7));
        assertThat(ioi.next(), is(8));
    }


    @Test(expected = NoSuchElementException.class)
    public void invocationOfNextMethodShouldThrowNoSuchElementException() {
        Iterator<Integer> it1 = Arrays.asList(1, 2, 3).iterator();
        IteratorOfIterators its = new IteratorOfIterators(new Iterator[]{it1});
        assertThat(its.next(), is(1));
        assertThat(its.next(), is(2));
        assertThat(its.next(), is(3));
        its.next();
    }
}