package ru.job4j.homeworks.tasks;

import org.junit.Test;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class Task11151Test {
    Task11151 test = new Task11151();

    @Test
    public void whenAskToDeleteMaxNumbersThenDoIt() {
        assertThat(test.deleteMax(new int[]{1, 2, 33, 3, 4, 33, 33, 5}), is(new int[]{1, 2, 3, 4, 5}));
    }

    @Test
    public void whenAskToDeleteMinNumbersThenDoIt() {
        assertThat(test.deleteMin(new int[]{1, 2, -33, 3, 4, -33, -33, 5}), is(new int[]{1, 2, 3, 4, 5}));
    }
}