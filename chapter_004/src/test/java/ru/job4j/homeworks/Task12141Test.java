package ru.job4j.homeworks;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class Task12141Test {
    Task12141 test = new Task12141();
    int[][] array = {{1, 4, 3}, {2, 3, 5}, {6, 2, 7}};

    @Test
    public void whenTryToCheckThatArrayLineSortedByPlusPlusThenReturnResult() {
        assertThat(test.sortedColumn(array, 2), is(1));
        assertThat(test.sortedColumn(array, 1), is(-1));
    }

    @Test
    public void whenTryToCheckThatArrayColumnSortedByMinusMinusThenReturnResult() {
        assertThat(test.sortedLine(array, 1), is(-1));
        assertThat(test.sortedLine(array, 2), is(1));
    }
}
