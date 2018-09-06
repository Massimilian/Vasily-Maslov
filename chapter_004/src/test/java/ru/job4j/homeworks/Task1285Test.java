package ru.job4j.homeworks;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class Task1285Test {
    Task1285 test = new Task1285();
    int[][] array = {{1, 2, 3}, {3, 2, 1}, {4, 4, 5}};

    @Test
    public void whenTryToFindTheSmallestCountInStringThenReturnTheNumberOfPosition() {
        assertThat(test.findMin(array, 2), is(0));
    }

    @Test
    public void whenTryToFindTheBiggestCountInTheStringThenReturnTheNumberOfPosition() {
        assertThat(test.findMax(array, 2), is(2));
    }
}
