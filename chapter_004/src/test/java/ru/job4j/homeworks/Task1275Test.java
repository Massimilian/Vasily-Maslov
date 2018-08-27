package ru.job4j.homeworks;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class Task1275Test {
    private Task1275 test = new Task1275();
    private int[][] array = {{1, -1, 1}, {-1, 1, 1111, 1, 0}, {}, {-1}};

    @Test
    public void whenAskTheNumberOfCrossingZeroThenReturnIt() {
        assertThat(test.howMuchChangeMinus(array), is(3));
    }
}
