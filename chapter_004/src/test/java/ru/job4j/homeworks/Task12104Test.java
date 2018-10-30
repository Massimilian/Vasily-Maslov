package ru.job4j.homeworks;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class Task12104Test {
    Task12104 test = new Task12104();
    int[][] array = {{1, 3, 2}, {1, 2, 5}, {5, 0, 9, 0}};

    @Test
    public void whenTryToFindMaxSumThenDoIt() {
        assertThat(test.findSum(array), is(9));
    }
}
