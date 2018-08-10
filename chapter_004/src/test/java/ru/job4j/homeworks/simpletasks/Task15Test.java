package ru.job4j.homeworks.simpletasks;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class Task15Test {
    private Task15 test = new Task15();
    private int[] array = {1, 2, 3, 4, 5};
    private int[] result = {3, 4, 5, 1, 2};

    @Test
    public void whenTryToMoveNumbersInArrayThenDoIt() {
        assertThat(test.shift(array, 3), is(result));
        array = new int[]{1, 2, 3, 4, 5};
        assertThat(test.shift(result, 2), is(array));
        assertThat(test.shift(array, array.length), is(array));
    }
}
