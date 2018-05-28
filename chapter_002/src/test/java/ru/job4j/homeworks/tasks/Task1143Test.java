package ru.job4j.homeworks.tasks;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class Task1143Test {
    @Test
    public void whenAskSunnyDaysThenReturnThen() {
        Task1143 test = new Task1143();
        assertThat(test.sunnyDays(new int[]{0, 0, 1, 2, 1, 2, 1, 2, 3, 3, 0, 0, 2, 3, 2, 3, 2, 3, 2, 3, 0, 0, 3, 4, 3, 4, 3, 4, 3, 2, 3}), is(new int[]{1, 2, 11, 12, 21, 22}));
    }
}
