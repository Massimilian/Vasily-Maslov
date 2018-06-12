package ru.job4j.homeworks.tasks;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class Task11160Test {
    int[] test = {-2, -1, 0, 1, 2, 3};

    @Test
    public void whenAskToAddTheNumberBeforeLastEvenThenDoIt() {
        assertThat(new Task11160().enterNumberBeforeLastEven(test, 1000), is(new int[]{-2, -1, 0, 1, 1000, 2, 3}));
    }

    @Test
    public void whenAskToAddTheNumberAfterFirstMinusThenDoIt() {
        assertThat(new Task11160().enterNumberAfterFirstMinus(test, 1000), is(new int[]{-2, 1000, -1, 0, 1, 2, 3}));
    }
}
