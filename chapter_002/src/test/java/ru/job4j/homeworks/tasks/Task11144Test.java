package ru.job4j.homeworks.tasks;

import org.junit.Test;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class Task11144Test {
    Task11144 test = new Task11144();

    @Test
    public void whenAskToChangeTwoNumbersThenChangeThem() {
        assertThat(test.arrayChangeElements(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 0}, 0, 25), is(new int[]{0, 2, 3, 4, 5, 6, 7, 8, 9, 1}));
    }
}
