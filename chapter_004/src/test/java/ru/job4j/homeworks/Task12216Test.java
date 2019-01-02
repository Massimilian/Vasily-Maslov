package ru.job4j.homeworks;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class Task12216Test {
    private Task12216 test = new Task12216();
    private int[][] array = {{1, 2, 3}, {2, 3, 4}, {3, 4, 5}, {4, 5, 6, 7}};
    private int[][] arrayString = {{2, 3, 4}, {1, 2, 3}, {3, 4, 5}, {4, 5, 6, 7}};
    private int[][] anotherArrayString = {{1, 2, 3}, {4, 5, 6, 7}, {3, 4, 5}, {2, 3, 4}};
    private int[][] arrayColumn = {{3, 2, 1, 0}, {4, 3, 2, 0}, {5, 4, 3, 0}, {6, 5, 4, 7}};
    private int[][] anotherArrayColumn = {{1, 2, 0, 3}, {2, 3, 0, 4}, {3, 4, 0, 5}, {4, 5, 7, 6}};

    @Test
    public void whenTryToChangeStringThenDoIt() {
        assertThat(test.changeString(array, 0, 1), is(arrayString));
        assertThat(test.changeString(array, 1, 3), is(anotherArrayString));
    }

    @Test
    public void whenTryToChangeColumnThenDoIt() {
        assertThat(test.changeColumn(array, 0, 2), is(arrayColumn));
        assertThat(test.changeColumn(array, 2, 3), is(anotherArrayColumn));
    }
}
