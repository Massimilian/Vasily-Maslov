package ru.job4j.homeworks.tasks;

import org.junit.Test;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class Task11149Test {

    @Test
    public void whenAskToDeleteNumberThenDoIt() {
        Task11149 test = new Task11149();
        assertThat(test.delete(new int[]{1, 2, 3, 4, 5, 6, 7, 7, 8, 9}, 8), is(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9}));
    }
}
