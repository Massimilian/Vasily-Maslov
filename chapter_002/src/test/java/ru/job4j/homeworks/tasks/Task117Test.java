package ru.job4j.homeworks.tasks;

import org.junit.Test;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class Task117Test {
    Task117 task = new Task117();

    @Test
    public void whenAskArrayThenReturnItEasyWay() {
        assertThat(task.easyNumbers(), is(new int[]{20, 19, 18, 17, 16, 15, 14, 13, 12, 11, 10, 9, 8, 7, 6, 5, 4, 3, 2, 1}));
    }

    @Test
    public void whenAskArrayThenReturn() {
        assertThat(task.numbers(20), is(new int[]{20, 19, 18, 17, 16, 15, 14, 13, 12, 11, 10, 9, 8, 7, 6, 5, 4, 3, 2, 1}));
    }
}