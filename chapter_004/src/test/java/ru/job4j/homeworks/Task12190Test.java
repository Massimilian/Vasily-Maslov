package ru.job4j.homeworks;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class Task12190Test {
    Task12190 test = new Task12190();
    private int[][] array = {{0, 1, 1, 1, 0}, {2, 0, 1, 0, 3}, {2, 2, 0, 3, 3}, {2, 0, 4, 0, 3}, {0, 4, 4, 4, 0}};
    private int[][] evenArray = {{0, 1, 1, 0}, {2, 0, 0, 3}, {2, 0, 0, 3}, {0, 4, 4, 0}};
    private int posUp = 1;
    private int posRight = 2;
    private int posDown = 3;
    private int posLeft = 4;

    @Test
    public void whenTryToFindTheSumOfQuarterThenDoIt() {
        assertThat(test.sumOfQuarter(array, posUp), is(4));
        assertThat(test.sumOfQuarter(evenArray, posUp), is(2));
        assertThat(test.sumOfQuarter(array, posRight), is(12));
        assertThat(test.sumOfQuarter(evenArray, posRight), is(6));
        assertThat(test.sumOfQuarter(array, posDown), is(16));
        assertThat(test.sumOfQuarter(evenArray, posDown), is(8));
        assertThat(test.sumOfQuarter(array, posLeft), is(8));
        assertThat(test.sumOfQuarter(evenArray, posLeft), is(4));
    }
}
