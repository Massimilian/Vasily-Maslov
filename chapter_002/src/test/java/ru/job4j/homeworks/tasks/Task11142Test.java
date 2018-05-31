package ru.job4j.homeworks.tasks;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class Task11142Test {
    @Test
    public void whenPutTheArrayThenReturnItWithTheChangedMaxAbs() {
        Task11142 test = new Task11142();
        assertThat(test.specialChange(new int[]{1, 2, -2}), is(new int[]{1, -2, -2}));
    }
}
