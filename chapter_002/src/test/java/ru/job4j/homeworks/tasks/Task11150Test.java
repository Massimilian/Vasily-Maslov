package ru.job4j.homeworks.tasks;

import org.junit.Test;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class Task11150Test {

    @Test
    public void whenAskToPutOutTheGoodThenDoIt() {
        Task11150 test = new Task11150();
        assertThat(test.minusGood(new int[]{200, 200, 200}, 0), is(new int[]{200, 200}));
    }
}
