package ru.job4j.homeworks.tasks;

import org.junit.Test;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class Task11163Test {

    @Test
    public void whenAskToPutTwoNumbersThenPutThemNearTheMax() {
        Task11163 test = new Task11163();
        assertThat(test.putNumber(new int[]{1, 3}, 2, 4), is(new int[]{1, 2, 3, 4}));
    }
}
