package ru.job4j.homeworks;

import org.junit.Test;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class Task11170Test {

    @Test
    public void whenAskToChangeThisTestThenReturnItChanged() {
        Task11170 test = new Task11170();
        assertThat(test.changeArray(new int[]{1, 5, 2, 3, 4, 6}, 2, 5), is(new int[]{1, 2, 3, 4, 5, 6}));
    }
}
