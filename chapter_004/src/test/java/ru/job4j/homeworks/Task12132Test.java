package ru.job4j.homeworks;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class Task12132Test {
    Task12132 test = new Task12132();
    int[][] array = {{1, 2, 3}, {}, {0, 4, 5}, {6, 7, 8, 9, 10}};
    int[][] secondArray = {{1, 2}, {10}, {0, 4, 3}, {5, 6, 7, 8, 9, 10}};

    @Test
    public void whenTryToFindEqualsThenDoIt() {
        assertThat(test.hasEquals(array), is(false));
        assertThat(test.hasEquals(secondArray), is(true));
    }
}
