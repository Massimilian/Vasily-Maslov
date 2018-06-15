package ru.job4j.homeworks;

import org.junit.Test;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class Task11167Test {

    @Test
    public void whenAskToPutNumbersIntoArrayThenDoIt() {
        Task11167 test = new Task11167();
        assertThat(test.putNumber(new int[]{543, 2, -35, 4, 3}, 0), is(new int[]{543, 0, 2, -35, 0, 4, 3}));
    }
}
