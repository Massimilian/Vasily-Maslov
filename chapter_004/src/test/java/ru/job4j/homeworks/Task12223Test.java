package ru.job4j.homeworks;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class Task12223Test {
    private Task12223 test = new Task12223();
    int[][] array = {{1, 2, 3}, {2, 3}, {3}, {}};
    int[][] result = {{}, {3}, {2, 3}, {1, 2, 3}};

    @Test
    public void whenTryToChangeArrayThenReturnItChanged() {
        assertThat(test.mirrorChange(array), is(result));
    }
}
