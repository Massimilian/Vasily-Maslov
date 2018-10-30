package ru.job4j.homeworks;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class Task12183Test {
    Task12183 test = new Task12183();
    int[][] array = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
    int[][] arrayNext = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}};

    @Test
    public void whenAskToSeparateArrayThenDoIt() {
        assertThat(test.halfArray(array, true), is(new int[][]{{1}, {4}, {7}}));
        assertThat(test.halfArray(array, false), is(new int[][]{{2, 3}, {5, 6}, {8, 9}}));
        assertThat(test.halfArray(arrayNext, true), is(new int[][]{{1, 2}, {5, 6}, {9, 10}, {13, 14}}));
        assertThat(test.halfArray(arrayNext, false), is(new int[][]{{3, 4}, {7, 8}, {11, 12}, {15, 16}}));
    }
}