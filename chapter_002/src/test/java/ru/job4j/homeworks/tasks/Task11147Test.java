package ru.job4j.homeworks.tasks;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class Task11147Test {
    Task11147 test = new Task11147();

    @Test
    public void whenAskToChangeSomeNumbersIntoArrayThenDoIt() {
        assertThat(test.changeElements(new int[]{1, 2, 3, 4, 5, 6, 7, 8}, 3, 5), is(new int[]{1, 2, 5, 4, 3, 6, 7, 8}));
    }

    @Test
    public void whenAskToChangeSomeNumbersBetweenMinAndMaxIntoArrayThenDoIt() {
        assertThat(test.changeElementsBetweenMaxMin(new int[]{1, 2, 3, 4, 5, 0}), is(new int[]{1, 2, 3, 4, 0, 5}));
    }
}
