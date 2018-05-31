package ru.job4j.homeworks.tasks;

import org.junit.Test;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class Task11146Test {
    @Test
    public void whenAskToTurnThePartsOfArrayThenDoIt() {
        Task11146 test = new Task11146();
        assertThat(test.changeElements(new int[]{1, 2, 3, 4, 5, 6, 7}, 20000), is(new int[]{5, 6, 7, 4, 1, 2, 3}));
    }
}
