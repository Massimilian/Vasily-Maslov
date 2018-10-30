package ru.job4j.homeworks;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class Task12142Test {
    Task12142 test = new Task12142();
    int[][] array = {{1, 2, 1, 3}, {4, 2, 3, 12}, {14, 2, 4, 6, 2, 3, 4}, {1, 7}, {}};

    @Test
    public void whenTryToFindFirstDivisibleThenReturnIt() {
        assertThat(test.firstDivisible(array, 7), is(new int[]{2, 0}));
    }

    @Test
    public void whenTryToFindLastMaxThenSomeNumberThenDoIt() {
        assertThat(test.lastMax(array, -1), is(new int[]{3, 1}));
    }
}
