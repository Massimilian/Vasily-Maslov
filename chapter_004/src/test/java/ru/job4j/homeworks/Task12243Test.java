package ru.job4j.homeworks;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class Task12243Test {
    private Task12243 test = new Task12243();
    private int[][] array = {{1, 2, 3}, {1, 2, 3, 4}, {1, 2, 3, 4, 5}, {1, 2, 3, 4}};
    private int[][] result = {{1, 2, 3}, {1, 2, 3, 4}, {0, 0, 0, 0}, {1, 2, 3, 4, 5}, {1, 2, 3, 4}};
    private int[][] arrayNext = {{1, 3, 2}, {0, 5, 10}, {4, 0, -7}};
    private int[][] resultNext = {{1, 3, 10, 2}, {0, 5, 10, 10}, {4, 0, 10, -7}};
    private int number = 0;
    private int count = 4;
    private int numberNext = 10;
    private int countNext = 7;

    @Test
    public void whenTryToChangeTheArrayThenDoIt() {
        assertThat(test.enterNumberString(array, number, count), is(result));
    }

    @Test
    public void whenTryToChangeTheColumnThenDoIt() {
        assertThat(test.enterNumbersColumn(arrayNext, numberNext, countNext), is(resultNext));
    }
}
