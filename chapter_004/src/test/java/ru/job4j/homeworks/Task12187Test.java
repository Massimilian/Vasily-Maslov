package ru.job4j.homeworks;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class Task12187Test {
    Task12187 test = new Task12187();
    int[][] array = {{1, 2, 3}, {2, 3, 2}, {1, 2, 10}};
    int[][] wrongArray = {{1, 2, 3}, {2, 3, 2}, {10, 2, 1}};

    @Test
    public void whenTryToCheckArrayThenReturnResult() {
        assertThat(test.findNum(array), is(new int[]{-1, -1}));
        assertThat(test.findNum(wrongArray), is(new int[]{2, 0}));
    }
}
