package ru.job4j.homeworks.tasks;

import org.junit.Test;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class Task11164Test {
    Task11164 test = new Task11164();
    int[] array = {-1, 1, 2, 3, 4, -6};

    @Test
    public void whenNeedToPutCheckPointBeforeNumbersDivisibleThenDoIt() {
        assertThat(test.numbers(array, 2, 0), is(new int[]{-1, 1, 0, 2, 3, 0, 4, 0, -6}));
    }

    @Test
    public void whenNeedToPutCheckPointAfterNumbersUnderZeroThenDoIt() {
        assertThat(test.numbersMinusVersion(array, 0), is(new int[]{-1, 0, 1, 2, 3, 4, -6, 0}));
    }
}
