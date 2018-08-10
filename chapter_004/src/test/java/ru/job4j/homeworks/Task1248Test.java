package ru.job4j.homeworks;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class Task1248Test {
    private Task1248 test = new Task1248();
    private int[][] counter = {{1, 2, 3}, {}};

    @Test
    public void whenAskPowsOfNumbersThenReturnIt() {
        assertThat(test.theSum(counter, 1), is(14));
        assertThat(test.theSum(counter, 2), is(0));
    }
}
