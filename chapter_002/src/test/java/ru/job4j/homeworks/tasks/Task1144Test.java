package ru.job4j.homeworks.tasks;

import org.junit.Test;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class Task1144Test {

    @Test
    public void whenAskCommandsOutsidersThenReturnThereNumbers() {
        Task1144 test = new Task1144();
        assertThat(test.viewOutsiders(new int[]{5, 5, 5, 2, 4, 5, 2, 0}), is(new int[]{4, 7, 8}));
    }
}
