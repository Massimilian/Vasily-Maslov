package ru.job4j.homeworks;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class Task12235Test {
    private Task12235 test = new Task12235();
    private int[][] array = {{1, 2, 3}, {1, 100, 0}, {2, 4, 7}};
    private int[][] arrayStringResult = {{1, 2, 3}, {2, 4, 7}, null};
    private int[][] arrayColumnResult = {{1, 2}, {1, 100}, {2, 4}};
    private int count = 100;
    private int secondCount = 1;

    @Test
    public void whenTryToDeleteStringThenDoIt() {
        assertThat(test.deleteMinThen(count, array), is(arrayStringResult));
    }

    @Test
    public void whenTryToDeleteColumnThenDoIt() {
        assertThat(test.deleteWithZeroes(secondCount, array), is(arrayColumnResult));
    }
}
