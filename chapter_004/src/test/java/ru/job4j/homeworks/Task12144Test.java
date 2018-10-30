package ru.job4j.homeworks;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class Task12144Test {
    Task12144 test = new Task12144();
    int[][] array = {{-1, -2, 0}, {-6, -2, -3}, {-1, -2, -3, 0}};

    @Test
    public void whenHasPositiveNumbersThenReturnTrue() {
        assertThat(test.hasPositive(array), is(false));
    }

    @Test
    public void whenHasNumberThenReturnTrue() {
        assertThat(test.hasNumber(array, 9), is(false));
        assertThat(test.hasNumber(array, 3), is(true));
    }
}
