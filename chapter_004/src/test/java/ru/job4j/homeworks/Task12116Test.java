package ru.job4j.homeworks;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class Task12116Test {
    Task12116 test = new Task12116();
    int[][] array = {{0, 1, 0, 0}, {0, 0, 0, 1}, {1, 1, 0, 1}};

    @Test
    public void whenTryToLookForThePlaceInVagonThenReturnIsLibreOrNo() {
        assertThat(test.hasPlace(array, 1, 3), is(false));
        assertThat(test.hasPlace(array, 0, 3), is(true));
    }
}
