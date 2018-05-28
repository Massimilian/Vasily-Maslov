package ru.job4j.homeworks.tasks;

import org.junit.Test;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class Task1155Test {
    Task1155 test = new Task1155();

    @Test
    public void whenAskTheSumOfEvensThenReturnIt() {
        assertThat(test.sumOfNotSomeNumbers(new int[]{1, 2, 3, 4, 5, 6, 7, 8}, 2, 1), is(20));
    }

    @Test
    public void whenAskTheSumOfSpecialNumberThenReturnIt() {
        assertThat(test.sumOfNotSomeNumbers(new int[]{1, 2, 3, 4, 5, 6, 7, 8}, 4, 1), is(12));
    }

    @Test
    public void whenAskTheSumOfSpecialNumbersThenReturnIt() {
        assertThat(test.sumOfNotSomeNumbers(new int[]{1, 2, 3, 4, 5, 6, 7, 8}, 2, 3), is(6));
    }
}
