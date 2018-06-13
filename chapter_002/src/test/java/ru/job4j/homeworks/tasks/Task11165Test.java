package ru.job4j.homeworks.tasks;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class Task11165Test {
    @Test
    public void whenAskToChangeTheArrayThenDoIt() {
        Task11165 test = new Task11165();
        assertThat(test.changed(new int[]{0, 0}, -1, 1), is(new int[]{-1, 0, 1, -1, 0, 1}));
    }
}
