package ru.job4j.homeworks;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class Task1262Test {
    Task1262 test = new Task1262();
    int[][] counter = {{1, 2, 3}, {1}, {3, 3, 2, 5}};

    @Test
    public void whenTryToUseThisClassThenItWorksWell() {
        assertThat(test.stringSum(counter), is(new int[]{6, 1, 13}));
        assertThat(test.postSum(counter), is(new int[]{5, 5, 5, 5}));
    }
}
