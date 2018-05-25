package ru.job4j.homeworks.tasks;

import org.junit.Test;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class Task111Test {

    @Test
    public void whenAskArrayThenReturnIt() {
        Task111 task = new Task111();
        assertThat(task.method(), is(new int[]{37, 0, 50, 46, 34, 46, 0, 13}));
    }
}
