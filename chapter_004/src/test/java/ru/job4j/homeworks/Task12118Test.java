package ru.job4j.homeworks;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class Task12118Test {
    Task12118 test = new Task12118();
    int[][] array = {{1, 2, 3, -1}, {4}, {5, 5, 3, 7, 6, 5, 87, 2}, {1, 2, 3, 4}};

    @Test
    public void whenTryToCheckIsTheSumHasNullAtTheEndThenReturnResult() {
        assertThat(test.finalOfSumIsZero(array, 2), is(true));
        assertThat(test.finalOfSumIsZero(array, 1), is(false));
    }

    @Test
    public void whenTryToCheckIsTheSumIsNotEvenThenReturnResult() {
        assertThat(test.sumIsNotEven(array, 1), is(false));
        assertThat(test.sumIsNotEven(array, 0), is(true));
    }
}
