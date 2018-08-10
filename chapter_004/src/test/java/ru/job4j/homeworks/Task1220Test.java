package ru.job4j.homeworks;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class Task1220Test {
    int[][] result = {{2, 10}, {3, 5, 16}, {102}};
    Task1220 test = new Task1220();

    @Test
    public void whenTryToFindEvenNumbersThenDoIt() {
        assertThat(test.hasEven(result), is(true));
    }

    @Test
    public void whenTryToFindNumbersWithZeroAtTheEndThenDoIt() {
        assertThat(test.hasNulls(result), is(false));
    }
}
