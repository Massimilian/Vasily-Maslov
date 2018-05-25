package ru.job4j.homeworks.tasks;

import org.junit.Test;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class Task1112Test {
    Task1112 test = new Task1112();

    @Test
    public void whenAskArrayWithNumbersThenReturnIt() {
        assertThat(test.numberTakeAway(9, 5, 9, 10), is(new int[]{9, 10, 18, 20, 27}));
    }

    @Test
    public void whenAskArrayWithSimpleNumbersThenReturnIt() {
        assertThat(test.naturalNumbersArray(0, 15), is(new int[]{0, 1, 2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41}));
    }
}
