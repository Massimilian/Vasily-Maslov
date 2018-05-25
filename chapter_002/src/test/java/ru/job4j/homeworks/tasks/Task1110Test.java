package ru.job4j.homeworks.tasks;

import org.junit.Test;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class Task1110Test {
    Task1110 test = new Task1110();

    @Test
    public void whenPutANumberThenReturnItTurnedAndInArray() {
        assertThat(test.makeArray(23434), is(new int[]{4, 3, 4, 3, 2, 0}));
    }

    @Test
    public void whenPutANumberThenReturnItTurnedAndInArrayStringVercion() {
        assertThat(test.makeStringArray(423), is(new String[]{"3", "2", "4", "0", "0", "0"}));
    }
}
