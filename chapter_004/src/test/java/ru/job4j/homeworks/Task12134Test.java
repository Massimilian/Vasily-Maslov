package ru.job4j.homeworks;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class Task12134Test {
    Task12134 test = new Task12134();
    int[][] array = {{1, 3, 4}, {2, 5, 6, 7, 14}, {0, 8}, {9}, {7, 10, 11, 13, 12}};

    @Test
    public void whenTryToFindEqualNumbersThenReturnIt() {
        assertThat(test.findTwins(array), is(7));
    }
}
