package ru.job4j.homeworks.tasks;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class Task11159Test {
    @Test
    public void whenTryToEnterNumbersIntoArrayThenDoIt() {
        assertThat(new Task11159().enterNumbers(new int[]{1, 2, 3, 4, 5, 6, 7}, 0, 2), is(new int[]{1, 2, 0, 3, 4, 0, 5, 6, 0, 7}));
    }

    public void whenTryToEnterNumbersIntoArrayWithErrorFrequencyThenDoIt() {
        assertThat(new Task11159().enterNumbers(new int[]{1}, 1, 0), is(new int[]{1}));
    }
}
