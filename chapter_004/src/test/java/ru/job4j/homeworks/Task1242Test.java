package ru.job4j.homeworks;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class Task1242Test {
    private Task1242 test = new Task1242();

    @Test
    public void whenAskNumberOfFreePlacesThenReturnIt() {
        assertThat(test.empties(new int[][]{
                {1, 0, 1, 1, 1, 0, 0, 1, 0, 1, 1, 1, 0, 0, 0},
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0},
                {0, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1},
                {0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 1, 1, 1, 1, 1}
        }, 1), is(7));
    }
}
