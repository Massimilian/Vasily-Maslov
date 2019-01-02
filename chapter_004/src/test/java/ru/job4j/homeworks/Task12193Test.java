package ru.job4j.homeworks;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class Task12193Test {
    private Task12193 test = new Task12193();
    private int[][] array = {{2, 0, 2, 2, 1}, {1, 0}, {3}, {3, 2}, {}};
    private int[][] result = {{2, 0, 2, 2, 1}, {1, 3}, {0}, {3, 2}, {}};

    @Test
    public void whenTryToChangeMinAndMaxThenDoIt() {
        assertThat(test.changeMinAndMax(array), is(result));
    }
}
