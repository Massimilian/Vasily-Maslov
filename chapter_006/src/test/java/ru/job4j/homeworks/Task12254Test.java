package ru.job4j.homeworks;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class Task12254Test {
    private Task12254 test = new Task12254();
    private int[][] array = {{1, 1, 1}, {2, 2, 2}, {3, 3, 3}, {4, 4, 4}, {5, 5, 5, 5, 5}, {6}, {7}, {8, 8}};
    private int[][] result = {{6}, {7}, {8, 8}, {1, 1, 1}, {2, 2, 2}, {3, 3, 3}, {4, 4, 4}, {5, 5, 5, 5, 5}};
    private int count = 5;

    @Test
    public void whenTryToGetNewArrayWithChangedStringsThenDoIt() {
        assertThat(test.changeStrings(array, count), is(result));
    }
}
