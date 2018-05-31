package ru.job4j.homeworks.tasks;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class Task11140Test {
    Task11140 test = new Task11140();
    int[] testingArray = {-1, 2, 2, 3, 0, 0, 2, 3, 4, 3, -2, 3, 2, -1};

    @Test
    public void whenAskTheMostColdDaysThenReturnThemWithOneParameter() {
        assertThat(test.mostColdDays(testingArray), is(new int[]{11, 1}));
    }

    @Test
    public void whenAskTheMostColdDaysThenReturnThemWithTwoParameteres() {
        assertThat(test.mostColdDays(testingArray, 5), is(new int[]{1, 5, 6, 11, 14}));
    }
}
