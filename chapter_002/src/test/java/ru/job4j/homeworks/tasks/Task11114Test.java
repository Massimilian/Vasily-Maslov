package ru.job4j.homeworks.tasks;

import org.junit.Test;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class Task11114Test {
    @Test
    public void whenAskTheFinalMarkThenReturnIt() {
        Task11114 test = new Task11114();
        assertThat(test.finalMark(new int[]{8, 9, 9, 8, 7, 8, 9, 10, 10, 6}), is(8.5));
    }
}
