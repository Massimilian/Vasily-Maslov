package ru.job4j.homeworks;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class Task12175Test {
    Task12175 test = new Task12175();
    int[][] array = {{1, 1, 1}, {2, 2, 2}, {0, 0, 0}};

    @Test
    public void whenTryToFindMinPositionThenDoIt() {
        assertThat(test.returnMin(array), is(2));
    }

    @Test
    public void whenTryToFindMaxPositionThenDoIt() {
        assertThat(test.returnMin(array), is(2));
    }

}
