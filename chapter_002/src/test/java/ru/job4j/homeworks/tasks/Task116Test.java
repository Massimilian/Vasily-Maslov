package ru.job4j.homeworks.tasks;

import org.junit.Test;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class Task116Test {
    Task116 task = new Task116();

    @Test
    public void whenAskArrayThenReturnItEasyWay() {
        assertThat(task.easyNumbers(), is(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12}));
    }

    @Test
    public void whenAskArrayThenReturn() {
        assertThat(task.numbers(), is(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12}));
    }
}
