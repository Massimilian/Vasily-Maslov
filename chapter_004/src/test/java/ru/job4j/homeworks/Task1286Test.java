package ru.job4j.homeworks;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class Task1286Test {
    Task1286 test = new Task1286();
    int[][] array = {{1, 2, 3}, {3, 1, 2}, {2, 2, 0}};

    @Test
    public void whenTryToFindMaxThenDoIt() {
        assertThat(test.findMax(array, 1), is(0));
        assertThat(test.findMax(array, 0), is(1));
    }

    @Test
    public void whenTryToFindMinThenDoIt() {
        assertThat(test.findMin(array, 0), is(0));
        assertThat(test.findMin(array, 2), is(2));
    }
}
