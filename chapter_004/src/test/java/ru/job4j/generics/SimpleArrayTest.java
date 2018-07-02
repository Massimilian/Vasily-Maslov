package ru.job4j.generics;


import org.junit.Test;

import java.util.Iterator;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class SimpleArrayTest {
    private SimpleArray<Integer> arr = new SimpleArray<>(3);

    @Test
    public void whenAddTwoWaysThenGetIt() {
        arr.add(1);
        arr.add(2, 3);
        arr.add(2);
        arr.add(4);
        int result = arr.get(0);
        assertThat(result, is(1));
    }

    @Test
    public void whenSetThenReturnIt() {
        arr.add(1);
        arr.add(2, 3);
        arr.set(2, 10);
        assertThat(arr.get(2), is(10));
    }

    @Test
    public void whenAskToDeleteThenDoIt() {
        arr.add(2, 3);
        arr.delete(2);
        assertThat(arr.get(2), is((Integer) null)); // согласен, странная запись - каст null в Integer.
        // Но при написании элементарного ноля или null тест не проходит. Это можно забороть другим путём?
    }

    @Test
    public void whenTryToUseIteratorThenUseIt() {
        arr.add(0);
        arr.add(1);
        arr.add(2);
        Iterator<Integer> iterator = arr.iterator();
        int result = 0;
        while (iterator.hasNext()) {
            result += iterator.next();
        }
        assertThat(result, is(3));
    }
}
