package ru.job4j.homeworks.tasks;

import org.junit.Test;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class Task118Test {
    Task118 test = new Task118();

    @Test
    public void whenAskMinusArrayThenReturnIt() {
        assertThat(test.arrayMinus(8), is(new int[]{8, 7, 6, 5, 4, 3, 2, 1}));
    }

    @Test
    public void whenAskPlusArrayThenReturnIt() {
        assertThat(test.arrayPlus(12), is(new int[]{12, 13, 14, 15, 16, 17, 18, 19}));
    }
}
