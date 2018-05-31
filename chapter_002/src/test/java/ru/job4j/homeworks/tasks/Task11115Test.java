package ru.job4j.homeworks.tasks;

import org.junit.Test;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class Task11115Test {
    Task11115 test = new Task11115();

    @Test
    public void whenAskTheMostFastCarThenReturnWhereIfIs() {
        assertThat(test.maxSpeedy(new int[]{300, 350, 250, 350, 280, 250, 300, 300}), is(2));
    }

    @Test
    public void whenAskAllMostFastCarsThenReturnThemAll() {
        assertThat(test.allSpeedyCars(new int[]{300, 350, 250, 350, 280, 250, 300, 300}), is(new int[]{2, 4}));
    }
}
