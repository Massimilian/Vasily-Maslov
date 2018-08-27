package ru.job4j.homeworks;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class Task1283Test {
    Task1283 test = new Task1283();
    int[][] array = {{1, 2, 3}, {2, 0, 0}, {Integer.MAX_VALUE, Integer.MIN_VALUE, 0}, {-100, 2, 5}};

    @Test
    public void whenTryToFindMinNumberThenGetIt() {
        assertThat(test.findMin(array), is(new int[]{1, 0, Integer.MIN_VALUE, -100}));
    }

    @Test
    public void whenTryToFindMaxNumberThenDoIt() {
        assertThat(test.findMax(array), is(new int[]{Integer.MAX_VALUE, 2, 5}));
    }
}