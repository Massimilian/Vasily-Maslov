package ru.job4j.homeworks;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class Task11181Test {

    @Test
    public void whenAskToAddIntoArrayTheFirstAndLastBigNumber() {
        Task11181 test = new Task11181();
        assertThat(test.findAllBigger(new int[]{0, 5, 4, 3, 4, 5}, 4), is(new int[]{2, 6}));
    }
}
