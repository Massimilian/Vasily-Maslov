package ru.job4j.homeworks;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class Task12234Test {
    private Task12234 test = new Task12234();
    private int[][] array = {{0, 1, 2}, {1, 2, 3, 4}, {2, 3}, {3, 4, 5, 6, 7, 8}};
    private int[][] arrayWithoutString = {{0, 1, 2}, {2, 3}, {3, 4, 5, 6, 7, 8}};
    private int[][] arrayWithoutColumn = {{0, 2}, {1, 3, 4}, {2}, {3, 5, 6, 7, 8}};

    @Test
    public void whenTryToDeleteStringThenDoIt() {
        assertThat(test.deleteString(array, 1), is(arrayWithoutString));
    }

    @Test
    public void whenTryToDeleteColumnThenDoIt() {
        assertThat(test.deleteColumn(array, 1), is(arrayWithoutColumn));
    }
}
