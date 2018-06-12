package ru.job4j.homeworks.tasks;

import org.junit.Test;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class Task11154Test {

    @Test
    public void whenAskToDeleteMinAndMaxElementsThenDoIt() {
        Task11154 test = new Task11154();
        assertThat(test.deleteMaxMin(new int[]{1, 2, 3, 4, 5}), is(new int[]{2, 3, 4}));
    }
}
