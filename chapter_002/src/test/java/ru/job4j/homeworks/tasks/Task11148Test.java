package ru.job4j.homeworks.tasks;

import org.junit.Test;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class Task11148Test {

    @Test
    public void whenPutDifferentNumbersIntoArrayThenChangeFirstMinusAndLastPlusAndReturn() {
        Task11148 test = new Task11148();
        assertThat(test.changeFirstPlusMinusElements(new int[]{0, 0, 0, 1, -1, 2, -2, 3}), is(new int[]{0, 0, 0, 1, 3, 2, -2, -1}));
    }
}
